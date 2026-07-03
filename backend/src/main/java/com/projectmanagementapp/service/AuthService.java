package com.projectmanagementapp.service;

import com.projectmanagementapp.dto.LoginRequest;
import com.projectmanagementapp.dto.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public LoginResponse login(LoginRequest request) {
        String token = "demo-token-for-" + request.email().replace("@", "_at_");
        return new LoginResponse("Demo User", token, "繝ｭ繧ｰ繧､繝ｳ縺ｫ謌仙粥縺励∪縺励◆");
    }
}

