package com.ensa.Gestion_de_Presence.model.user;

import com.ensa.Gestion_de_Presence.model.Absence;
import com.ensa.Gestion_de_Presence.model.Classe;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Etudiant extends Utilisateur {
    private String numeroEtudiant;

    @DBRef
    private Classe classe;

    @DBRef
    private List<Absence> absences;
}