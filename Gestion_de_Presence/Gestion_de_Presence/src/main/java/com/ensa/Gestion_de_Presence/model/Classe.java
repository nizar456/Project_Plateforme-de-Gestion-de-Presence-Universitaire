package com.ensa.Gestion_de_Presence.model;

import com.ensa.Gestion_de_Presence.model.user.Etudiant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "classes")
public class Classe {
    @Id
    private String id;
    private String nom;
    private String filiere;

    @DBRef
    private List<Etudiant> etudiants; // Liste des étudiants de la classe
    public void addEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
    }
}