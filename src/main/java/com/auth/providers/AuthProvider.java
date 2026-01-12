package com.auth.providers;

import com.auth.core.AuthRequest;
import com.auth.core.AuthResult;

public interface AuthProvider {
    AuthResult authenticate(AuthRequest request);
}
