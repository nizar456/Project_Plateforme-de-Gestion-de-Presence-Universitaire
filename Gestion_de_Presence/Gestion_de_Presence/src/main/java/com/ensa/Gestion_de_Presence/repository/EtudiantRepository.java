package com.ensa.Gestion_de_Presence.repository;

import com.ensa.Gestion_de_Presence.model.user.Etudiant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EtudiantRepository extends MongoRepository<Etudiant, String> {
    // Méthodes spécifiques aux étudiants
}
