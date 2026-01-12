package com.auth.core;

import com.auth.model.AuthType;

public class AuthRequest {

    private AuthType type;
    private String email;
    private String credential; // password o token

    // 👉 Constructor para Google
    public AuthRequest(AuthType type, String credential, String email) {
        this.type = type;
        this.credential = credential;
        this.email = email;
    }

    // 👉 Constructor para login local
    public AuthRequest(String email, String password) {
        this.type = AuthType.LOCAL;
        this.email = email;
        this.credential = password;
    }

    public AuthType getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public String getCredential() {
        return credential;
    }
}

