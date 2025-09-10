package com.example.keycloak;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "keycloak")
@Getter @Setter
public class KeycloakProperties {
    private String serverUrl;
    private String realm;

    private String tokenClientId;
    private String tokenClientSecret;

    private String adminClientId;
    private String adminUsername;
    private String adminPassword;
}
