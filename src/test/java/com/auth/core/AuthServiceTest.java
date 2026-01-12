package com.auth.core;


import com.auth.model.AuthType;
import com.auth.providers.AuthProvider;
import com.auth.providers.GoogleAuthProvider;
import com.auth.providers.LocalAuthProvider;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    @Test
    void shouldAuthenticateLocalUser() {

        // Providers
        AuthProvider localProvider = new LocalAuthProvider();
        AuthProvider googleProvider = new GoogleAuthProvider();

        // Mapa de providers
        Map<AuthType, AuthProvider> providers = Map.of(
                AuthType.LOCAL, localProvider,
                AuthType.GOOGLE, googleProvider
        );

        // AuthService
        AuthService authService = new AuthService(providers);

        // Request LOCAL
        AuthRequest request = new AuthRequest(
                "test@correo.com",
                "123456"
        );

        // Ejecutar
        AuthResult result = authService.authenticate(request);

        // Validar
        assertTrue(result.isAuthenticated());
        assertEquals("test@correo.com", result.getUser().getEmail());
    }

    @Test
    void shouldFailWhenPasswordIsEmpty() {

        AuthProvider localProvider = new LocalAuthProvider();
        AuthProvider googleProvider = new GoogleAuthProvider();

        Map<AuthType, AuthProvider> providers = Map.of(
                AuthType.LOCAL, localProvider,
                AuthType.GOOGLE, googleProvider
        );

        AuthService authService = new AuthService(providers);

        // Password vacío
        AuthRequest request = new AuthRequest(
                "test@correo.com",
                ""
        );

        AuthResult result = authService.authenticate(request);

        assertFalse(result.isAuthenticated());
    }

    @Test
    void shouldUseGoogleProvider() {

        AuthProvider localProvider = new LocalAuthProvider();
        AuthProvider googleProvider = new GoogleAuthProvider();

        Map<AuthType, AuthProvider> providers = Map.of(
                AuthType.LOCAL, localProvider,
                AuthType.GOOGLE, googleProvider
        );

        AuthService authService = new AuthService(providers);

        // Request GOOGLE
        AuthRequest request = new AuthRequest(
                AuthType.GOOGLE,
                "google-token",
                "user@gmail.com"
        );

        AuthResult result = authService.authenticate(request);

        assertTrue(result.isAuthenticated());
        assertEquals("user@gmail.com", result.getUser().getEmail());
    }
}
