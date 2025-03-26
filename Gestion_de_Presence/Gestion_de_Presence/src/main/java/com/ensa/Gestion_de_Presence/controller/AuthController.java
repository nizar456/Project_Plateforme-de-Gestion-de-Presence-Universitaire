package com.ensa.Gestion_de_Presence.controller;

import com.ensa.Gestion_de_Presence.dto.AdminResetPasswordRequest;
import com.ensa.Gestion_de_Presence.dto.AuthRequest;
import com.ensa.Gestion_de_Presence.dto.AuthResponse;
import com.ensa.Gestion_de_Presence.dto.ChangePasswordRequest;
import com.ensa.Gestion_de_Presence.model.user.Utilisateur;
import com.ensa.Gestion_de_Presence.repository.UserRepository;
import com.ensa.Gestion_de_Presence.service.JwtService;
import com.ensa.Gestion_de_Presence.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository utilisateurRepository;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        final String jwt = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(
            @RequestHeader("Authorization") String token,
            @RequestBody ChangePasswordRequest request
    ) {
        String email = jwtService.extractUsername(token.substring(7));
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!passwordEncoder.matches(request.getOldPassword(), utilisateur.getPassword())) {
            throw new RuntimeException("Ancien mot de passe incorrect");
        }

        utilisateur.setPassword(passwordEncoder.encode(request.getNewPassword()));
        utilisateurRepository.save(utilisateur);

        return ResponseEntity.ok("Mot de passe changé avec succès");
    }

    // Endpoint admin pour réinitialiser les mots de passe
    @PostMapping("/admin/reset-password")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> adminResetPassword(
            @RequestBody AdminResetPasswordRequest request
    ) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        utilisateur.setPassword(passwordEncoder.encode(request.getNewPassword()));
        utilisateurRepository.save(utilisateur);

        return ResponseEntity.ok("Mot de passe réinitialisé avec succès");
    }
}