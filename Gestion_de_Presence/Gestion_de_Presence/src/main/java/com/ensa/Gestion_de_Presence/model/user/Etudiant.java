package com.ensa.Gestion_de_Presence.model.user;

import com.ensa.Gestion_de_Presence.model.Classe;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "etudiants")
public class Etudiant {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String numeroEtudiant;

    @DBRef
    @Setter
    private Classe classe; // Référence à la classe
    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    // Lombok @Data génère automatiquement getters/setters
}