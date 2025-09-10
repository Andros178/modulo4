package com.example.keycloak;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class KeycloakTokenService {

    private final KeycloakProperties props;
    private final WebClient.Builder webClientBuilder;

    public JsonNode directGrant(String username, String password) {
        String tokenUrl = props.getServerUrl() + "/realms/" + props.getRealm() + "/protocol/openid-connect/token";

        BodyInserters.FormInserter<String> form = BodyInserters
                .fromFormData("grant_type", "password")
                .with("client_id", props.getTokenClientId())
                .with("username", username)
                .with("password", password);

        if (props.getTokenClientSecret() != null && !props.getTokenClientSecret().isBlank()) {
            form.with("client_secret", props.getTokenClientSecret());
        }

        return webClientBuilder.build()
                .post()
                .uri(tokenUrl)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(form)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
    }
}
