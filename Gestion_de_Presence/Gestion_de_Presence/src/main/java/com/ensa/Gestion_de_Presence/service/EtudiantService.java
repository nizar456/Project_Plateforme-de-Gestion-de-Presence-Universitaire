package com.ensa.Gestion_de_Presence.service;

import com.ensa.Gestion_de_Presence.dto.EtudiantDTO;
import com.ensa.Gestion_de_Presence.model.Classe;
import com.ensa.Gestion_de_Presence.model.user.Etudiant;
import com.ensa.Gestion_de_Presence.repository.ClasseRepository;
import com.ensa.Gestion_de_Presence.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantService {
    private final EtudiantRepository etudiantRepository;
    private final ClasseRepository classeRepository;

    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository, ClasseRepository classeRepository) {
        this.etudiantRepository = etudiantRepository;
        this.classeRepository = classeRepository;
    }

    // Créer un étudiant + l'affecter à une classe
    public  EtudiantDTO createEtudiant(Etudiant etudiant, String classeId) {
        Classe classe = classeRepository.findById(classeId)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée"));

        etudiant.setClasse(classe);
        Etudiant saved = etudiantRepository.save(etudiant);

        classe.getEtudiants().add(saved);
        classeRepository.save(classe);

        return convertToDto(saved);
    }
    private EtudiantDTO convertToDto(Etudiant etudiant) {
        EtudiantDTO dto = new EtudiantDTO();
        // Copiez les propriétés
        dto.setId(etudiant.getId());
        // ... autres propriétés

        if(etudiant.getClasse() != null) {
            EtudiantDTO.ClasseInfo classeInfo = new EtudiantDTO.ClasseInfo();
            classeInfo.setId(etudiant.getClasse().getId());
            classeInfo.setNom(etudiant.getClasse().getNom());
            dto.setClasse(classeInfo);
        }

        return dto;
    }


    // Lister tous les étudiants
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    // Supprimer un étudiant
    public void deleteEtudiant(String id) {
        etudiantRepository.deleteById(id);
    }
}