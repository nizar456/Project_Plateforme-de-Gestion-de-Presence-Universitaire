package com.ensa.Gestion_de_Presence.repository;

import com.ensa.Gestion_de_Presence.model.ModuleClasse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ModuleClasseRepository extends MongoRepository<ModuleClasse, String> {
    List<ModuleClasse> findByProfesseurId(String professeurId);
    List<ModuleClasse> findByClasseId(String classeId);
}