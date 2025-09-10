package com.example.keycloak;

import com.example.usuario.Usuario;
import com.example.usuario_rol.UsuarioRol;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
@RequiredArgsConstructor
public class KeycloakAdminService {

    private final KeycloakProperties props;
    private final WebClient.Builder webClientBuilder;

    private String adminAccessToken() {
        String tokenUrl = props.getServerUrl() + "/realms/master/protocol/openid-connect/token";

        JsonNode node = webClientBuilder.build()
                .post()
                .uri(tokenUrl)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("grant_type", "password")
                        .with("client_id", props.getAdminClientId())
                        .with("username", props.getAdminUsername())
                        .with("password", props.getAdminPassword()))
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        return node.get("access_token").asText();
    }

    public void syncUserAndRoles(Usuario usuario) {
        String adminToken = adminAccessToken();
        // Aquí implementas ensureUserInKeycloak() y assignRoles() como en la versión extendida.
    }
}
