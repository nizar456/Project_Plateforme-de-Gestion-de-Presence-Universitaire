package com.ensa.Gestion_de_Presence.repository;

import com.ensa.Gestion_de_Presence.model.user.Professeur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfesseurRepository extends MongoRepository<Professeur, String> {
    // Méthodes spécifiques aux professeurs
}