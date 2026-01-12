package com.auth.providers;

import com.auth.core.AuthRequest;
import com.auth.core.AuthResult;
import com.auth.model.UserIdentity;

public class LocalAuthProvider implements AuthProvider {
    
    @Override
    public AuthResult authenticate(AuthRequest request) {
        

        

        // 🔐 Validación básica (esto arregla el test shouldFail)
        if (request.getCredential() == null || request.getCredential().isBlank()) {
            return new AuthResult(false, null);
        }

        // Simulación de usuario local
        UserIdentity user = new UserIdentity(
            "local-123",
            request.getEmail(),
            "Local User"
        );

        return new AuthResult(true, user);
    }
}