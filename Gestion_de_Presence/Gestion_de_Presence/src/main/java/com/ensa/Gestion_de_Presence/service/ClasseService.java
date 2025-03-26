package com.ensa.Gestion_de_Presence.service;

import com.ensa.Gestion_de_Presence.model.Classe;
import com.ensa.Gestion_de_Presence.repository.ClasseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClasseService {
    private final ClasseRepository classeRepository;

    // Créer une classe
    public Classe createClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    // Lister toutes les classes
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    // Supprimer une classe
    public void deleteClasse(String id) {
        classeRepository.deleteById(id);
    }
}