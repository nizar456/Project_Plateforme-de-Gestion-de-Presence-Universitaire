package com.ensa.Gestion_de_Presence.service;

import com.ensa.Gestion_de_Presence.model.user.Etudiant;
import com.ensa.Gestion_de_Presence.model.user.Professeur;
import com.ensa.Gestion_de_Presence.repository.EtudiantRepository;
import com.ensa.Gestion_de_Presence.repository.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final EtudiantRepository etudiantRepository;
    private final ProfesseurRepository professeurRepository;

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

}