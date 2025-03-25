package com.ensa.Gestion_de_Presence.repository;

import com.ensa.Gestion_de_Presence.model.Classe;
import com.ensa.Gestion_de_Presence.model.user.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClasseRepository extends MongoRepository<Classe, String> {
}