package com.auth.core;


import com.auth.model.AuthType;
import com.auth.providers.AuthProvider;

import java.util.Map;

public class AuthService {

    private final Map<AuthType, AuthProvider> providers;

    public AuthService(Map<AuthType, AuthProvider> providers) {
        this.providers = providers;
    }

    public AuthResult authenticate(AuthRequest request) {
        AuthProvider provider = providers.get(request.getType());

        if (provider == null) {
            throw new RuntimeException("Auth provider not supported");
        }

        return provider.authenticate(request);
    }
}
