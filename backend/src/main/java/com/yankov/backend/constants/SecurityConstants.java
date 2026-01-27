package com.yankov.backend.constants;

public class SecurityConstants {
    private SecurityConstants() {}

    // Roles
    public static final String ROLE_PREFIX = "ROLE_";

    // Endpoints
    public static final String AUTH_ENDPOINT = "/api/auth/**";

    // HTTP
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTHENTICATION_HEADER = "Authorization";

    // JWT
    public static final String JWT_ISSUER = "digital-banking-platform";
}
