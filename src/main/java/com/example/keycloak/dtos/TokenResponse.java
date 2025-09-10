package com.example.keycloak.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {
    private String accessToken;
    private String refreshToken; // opcional (puede ser null)

    public TokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
