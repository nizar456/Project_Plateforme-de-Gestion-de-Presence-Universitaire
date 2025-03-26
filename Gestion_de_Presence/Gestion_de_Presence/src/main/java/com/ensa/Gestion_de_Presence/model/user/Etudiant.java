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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    private String nom;
    private String prenom;
    private String email;
    private String numeroEtudiant;

    @DBRef(lazy = true)  // Référence lazy pour meilleure performance
    private Classe classe; // Référence à la classe
    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    // Lombok @Data génère automatiquement getters/setters
}