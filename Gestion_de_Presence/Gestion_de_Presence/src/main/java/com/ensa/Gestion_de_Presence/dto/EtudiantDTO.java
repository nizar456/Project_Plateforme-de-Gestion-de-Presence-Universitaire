package com.ensa.Gestion_de_Presence.dto;

import lombok.Data;

@Data
public class EtudiantDTO {
    private String id;
    private String nom;
    private String prenom;
    private String email;

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

    public ClasseInfo getClasse() {
        return classe;
    }

    public void setClasse(ClasseInfo classe) {
        this.classe = classe;
    }

    private String numeroEtudiant;
    private ClasseInfo classe; // Référence simplifiée

    @Data
    public static class ClasseInfo {
        private String id;
        private String nom;

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

        public String getFiliere() {
            return filiere;
        }

        public void setFiliere(String filiere) {
            this.filiere = filiere;
        }

        private String filiere;
    }
}
