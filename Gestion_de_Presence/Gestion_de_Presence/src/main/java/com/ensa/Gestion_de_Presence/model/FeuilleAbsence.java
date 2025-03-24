package com.ensa.Gestion_de_Presence.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "feuille_absences")
public class FeuilleAbsence {
    @Id
    private String id;
    private LocalDateTime date;
    private String heureDebut;
    private String heureFin;

    @DBRef
    private ModuleClasse moduleClasse;

    @DBRef
    private List<Absence> absences;
}