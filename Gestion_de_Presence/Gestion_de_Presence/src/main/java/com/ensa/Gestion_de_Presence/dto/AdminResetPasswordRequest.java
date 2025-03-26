package com.ensa.Gestion_de_Presence.dto;

import lombok.Data;

@Data
public class AdminResetPasswordRequest {
    private String email;
    private String newPassword;
}
