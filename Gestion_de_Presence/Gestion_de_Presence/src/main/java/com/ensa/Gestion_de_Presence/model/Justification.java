package com.ensa.Gestion_de_Presence.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "justifications")
public class Justification {
    @Id
    private String id;

    @DBRef
    private Absence absence;

    private String fichierUrl; // Chemin ou URL du fichier
    private String type; // "medical", "personnel", etc.
    private LocalDateTime dateSoumission;

    private StatutJustification statut;

    public enum StatutJustification {
        EN_ATTENTE,
        ACCEPTEE,
        REFUSEE
    }
}