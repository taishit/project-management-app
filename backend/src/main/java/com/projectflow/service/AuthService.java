package com.projectflow.service;

import com.projectflow.dto.LoginRequest;
import com.projectflow.dto.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public LoginResponse login(LoginRequest request) {
        String token = "demo-token-for-" + request.email().replace("@", "_at_");
        return new LoginResponse("Demo User", token, "ログインに成功しました");
    }
}
