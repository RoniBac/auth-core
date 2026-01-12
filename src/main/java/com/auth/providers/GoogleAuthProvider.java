package com.auth.providers;

import com.auth.core.AuthRequest;
import com.auth.core.AuthResult;
import com.auth.model.UserIdentity;

public class GoogleAuthProvider implements AuthProvider {

    @Override
    public AuthResult authenticate(AuthRequest request) {

        // Aquí iría la validación real con Google
        // (SDK o API)

        UserIdentity user = new UserIdentity(
                "google-123",
                request.getEmail(),
                "Google User"
        );

        return new AuthResult(true, user);
    }
}
