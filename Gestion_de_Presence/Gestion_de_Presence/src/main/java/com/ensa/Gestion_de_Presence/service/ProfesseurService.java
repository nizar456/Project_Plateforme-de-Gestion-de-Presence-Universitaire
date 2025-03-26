package com.ensa.Gestion_de_Presence.service;

import com.ensa.Gestion_de_Presence.model.user.Professeur;
import com.ensa.Gestion_de_Presence.repository.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesseurService {

    private final ProfesseurRepository professeurRepository;

    // Créer un professeur
    public Professeur createProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    // Lister tous les professeurs
    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    // Supprimer un professeur
    public void deleteProfesseur(String id) {
        professeurRepository.deleteById(id);
    }
}
