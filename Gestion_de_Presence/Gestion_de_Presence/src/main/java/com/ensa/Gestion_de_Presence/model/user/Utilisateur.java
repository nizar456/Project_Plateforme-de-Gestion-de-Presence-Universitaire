package com.ensa.Gestion_de_Presence.model.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "utilisateurs")
@Data
public class Utilisateur {
    @Id
    private String id;
    private String nom;
    private String prenom;

    @Indexed(unique = true)
    private String email;

    private String password;
    private Role role;
    private boolean firstLogin = true;

    // Générez l'email automatiquement
    public void generateEmail() {
        this.email = this.nom.toLowerCase() + "." + this.prenom.toLowerCase() + "@ensakh.com";
    }
}

