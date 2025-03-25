package com.ensa.Gestion_de_Presence.service;

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
    public Etudiant createEtudiant(Etudiant etudiant, String classeId) {
        Classe classe = classeRepository.findById(classeId)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée"));

        // 1. Sauvegarder d'abord l'étudiant
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);

        // 2. Mettre à jour la référence dans la classe
        classe.addEtudiant(savedEtudiant);
        classeRepository.save(classe);

        // 3. Mettre à jour la référence dans l'étudiant
        savedEtudiant.setClasse(classe);
        return etudiantRepository.save(savedEtudiant);
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