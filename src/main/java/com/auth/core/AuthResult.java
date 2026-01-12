package com.auth.core;

import com.auth.model.UserIdentity;

public class AuthResult {

    private boolean authenticated;
    private UserIdentity user;

    public AuthResult(boolean authenticated, UserIdentity user) {
        this.authenticated = authenticated;
        this.user = user;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public UserIdentity getUser() {
        return user;
    }
}
