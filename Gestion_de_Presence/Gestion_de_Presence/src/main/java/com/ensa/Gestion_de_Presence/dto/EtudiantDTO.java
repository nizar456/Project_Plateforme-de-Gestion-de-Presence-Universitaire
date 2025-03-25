package com.ensa.Gestion_de_Presence.dto;

import lombok.Data;

@Data
public class EtudiantDTO {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String numeroEtudiant;
    private String classeId;
}
