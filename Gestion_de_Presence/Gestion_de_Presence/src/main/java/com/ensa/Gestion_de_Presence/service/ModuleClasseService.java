package com.ensa.Gestion_de_Presence.service;

import com.ensa.Gestion_de_Presence.model.ModuleClasse;
import com.ensa.Gestion_de_Presence.repository.ModuleClasseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleClasseService {
    private final ModuleClasseRepository moduleClasseRepository;

    public ModuleClasseService(ModuleClasseRepository moduleClasseRepository) {
        this.moduleClasseRepository = moduleClasseRepository;
    }

    // Affecter un module à une classe + professeur
    public ModuleClasse affecterModuleClasse(ModuleClasse moduleClasse) {
        return moduleClasseRepository.save(moduleClasse);
    }

    // Lister les modules par professeur
    public List<ModuleClasse> getModulesByProfesseur(String professeurId) {
        return moduleClasseRepository.findByProfesseurId(professeurId);
    }
}
