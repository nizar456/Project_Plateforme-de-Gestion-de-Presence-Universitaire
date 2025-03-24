package com.ensa.Gestion_de_Presence.model;

import com.ensa.Gestion_de_Presence.model.user.Professeur;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "module_classes")
public class ModuleClasse {
    @Id
    private String id;
    private String module; // Ex: "Algèbre", "Programmation Java"

    @DBRef
    private Classe classe;

    @DBRef
    private Professeur professeur;
}