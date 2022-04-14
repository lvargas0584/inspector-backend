package org.inspector.security.config;

import io.quarkus.arc.config.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ConfigProperties(prefix = "jwt")
public interface JwtConfiguration {

    @ConfigProperty(name = "secret-key")
    String secretKey();

    @ConfigProperty(name = "issuer")
    String issuer();

    @ConfigProperty(name = "audience")
    String audience();

    @ConfigProperty(name = "expiration-time")
    Integer expirationTime();
}