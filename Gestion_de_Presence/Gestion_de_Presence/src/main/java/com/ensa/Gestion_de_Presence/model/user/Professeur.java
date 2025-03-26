package com.ensa.Gestion_de_Presence.model.user;

import com.ensa.Gestion_de_Presence.model.ModuleClasse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Professeur extends Utilisateur {
    private String specialite;
    @JsonIgnore
    @DBRef
    private List<ModuleClasse> modulesEnseignes;
}