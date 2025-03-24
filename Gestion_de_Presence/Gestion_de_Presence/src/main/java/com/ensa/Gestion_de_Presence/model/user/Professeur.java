package com.ensa.Gestion_de_Presence.model.user;

import com.univ.presence.model.ModuleClasse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Professeur extends Utilisateur {
    private String specialite;

    @DBRef
    private List<ModuleClasse> modulesEnseignes;
}