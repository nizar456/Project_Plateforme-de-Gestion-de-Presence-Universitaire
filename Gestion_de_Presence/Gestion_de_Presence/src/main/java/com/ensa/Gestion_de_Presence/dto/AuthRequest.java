package com.ensa.Gestion_de_Presence.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}