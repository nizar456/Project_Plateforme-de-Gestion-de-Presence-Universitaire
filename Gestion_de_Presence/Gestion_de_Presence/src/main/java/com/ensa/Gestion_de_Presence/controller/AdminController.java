package com.ensa.Gestion_de_Presence.controller;

import com.ensa.Gestion_de_Presence.dto.EtudiantDTO;
import com.ensa.Gestion_de_Presence.model.Classe;
import com.ensa.Gestion_de_Presence.model.ModuleClasse;
import com.ensa.Gestion_de_Presence.model.user.Etudiant;
import com.ensa.Gestion_de_Presence.model.user.Professeur;
import com.ensa.Gestion_de_Presence.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    private final EtudiantService etudiantService;
    @Autowired
    private final ProfesseurService professeurService;
    @Autowired
    private final ClasseService classeService;
    @Autowired
    private final ModuleClasseService moduleClasseService;
    public AdminController(
            EtudiantService etudiantService,
            ProfesseurService professeurService,
            ClasseService classeService,
            ModuleClasseService moduleClasseService
    ) {
        this.etudiantService = etudiantService;
        this.professeurService = professeurService;
        this.classeService = classeService;
        this.moduleClasseService =moduleClasseService;
    }

    // === Gestion des Étudiants ===
    @PostMapping("/etudiants")
    public ResponseEntity<EtudiantDTO> createEtudiant(
            @RequestBody Etudiant etudiant,
            @RequestParam String classeId
    ) {
        return ResponseEntity.ok(etudiantService.createEtudiant(etudiant, classeId));
    }

    @GetMapping("/etudiants")
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        return ResponseEntity.ok(etudiantService.getAllEtudiants());
    }

    @DeleteMapping("/etudiants/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable String id) {
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.noContent().build();
    }

    // === Gestion des Professeurs ===
    @PostMapping("/professeurs")
    public ResponseEntity<Professeur> createProfesseur(@RequestBody Professeur professeur) {
        return ResponseEntity.ok(professeurService.createProfesseur(professeur));
    }

    @GetMapping("/professeurs")
    public ResponseEntity<List<Professeur>> getAllProfesseurs() {
        return ResponseEntity.ok(professeurService.getAllProfesseurs());
    }

    // === Gestion des Classes ===
    @PostMapping("/classes")
    public ResponseEntity<Classe> createClasse(@RequestBody Classe classe) {
        return ResponseEntity.ok(classeService.createClasse(classe));
    }

    @GetMapping("/classes")
    public ResponseEntity<List<Classe>> getAllClasses() {
        return ResponseEntity.ok(classeService.getAllClasses());
    }

    // === Affectation Module-Classe-Professeur ===
    @PostMapping("/module-classes")
    public ResponseEntity<ModuleClasse> affecterModuleClasse(@RequestBody ModuleClasse moduleClasse) {
        return ResponseEntity.ok(moduleClasseService.affecterModuleClasse(moduleClasse));
    }

    @GetMapping("/professeurs/{professeurId}/modules")
    public ResponseEntity<List<ModuleClasse>> getModulesByProfesseur(
            @PathVariable String professeurId
    ) {
        return ResponseEntity.ok(moduleClasseService.getModulesByProfesseur(professeurId));
    }
}