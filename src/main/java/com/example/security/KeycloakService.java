package com.example.security;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KeycloakService {

    private final WebClient.Builder webClientBuilder;

    private final String keycloakUrl = "http://localhost:8081/realms/mi-realm/protocol/openid-connect/token";
    private final String clientId = "mi-cliente";
    private final String clientSecret = "mi-secreto"; // opcional si el cliente está configurado confidencial

    public String getToken(String username, String password) {
        WebClient webClient = webClientBuilder.build();

        return webClient.post()
                .uri(keycloakUrl)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("client_id", clientId)
                        .with("client_secret", clientSecret)
                        .with("username", username)
                        .with("password", password)
                        .with("grant_type", "password"))
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(json -> json.get("access_token").asText())
                .block();
    }
}
