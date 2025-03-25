package com.ensa.Gestion_de_Presence.model.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "users")
public abstract class Utilisateur {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String role;
}