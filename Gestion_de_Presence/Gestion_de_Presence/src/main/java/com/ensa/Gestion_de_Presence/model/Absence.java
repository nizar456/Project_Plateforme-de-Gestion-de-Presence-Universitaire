package com.ensa.Gestion_de_Presence.model;

import com.ensa.Gestion_de_Presence.model.user.Etudiant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "absences")
public class Absence {
    @Id
    private String id;

    @DBRef
    private FeuilleAbsence feuilleAbsence;

    @DBRef
    private Etudiant etudiant;

    private StatutAbsence statut;

    public enum StatutAbsence {
        PRESENT,
        ABSENT_NON_JUSTIFIE,
        ABSENT_JUSTIFIE,
        EN_ATTENTE_JUSTIFICATIF
    }
}