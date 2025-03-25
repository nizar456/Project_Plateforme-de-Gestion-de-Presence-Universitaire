package com.ensa.Gestion_de_Presence.repository;

import com.ensa.Gestion_de_Presence.model.user.Etudiant;
import com.ensa.Gestion_de_Presence.model.user.Professeur;
import com.ensa.Gestion_de_Presence.model.user.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface UserRepository extends MongoRepository<Utilisateur, String> {
    // Requête générique (retourne une liste de Utilisateur)
    List<Utilisateur> findByRole(String role);

    // Requêtes typées avec @Query (pour un retour spécifique)
    @Query(value = "{'role': 'ETUDIANT'}")
    List<Etudiant> findAllEtudiants();

    @Query(value = "{'role': 'PROFESSEUR'}")
    List<Professeur> findAllProfesseurs();
}