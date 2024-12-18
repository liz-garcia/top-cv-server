package com.topcv.topcvserver.controllers;

import com.topcv.topcvserver.models.LoginRequest;
import com.topcv.topcvserver.models.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    // Login endpoint
    @PostMapping("/api/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest loginRequest) { // still need to set up validation
        // TODO: Implement login logic using loginRequest

        return LoginResponse.builder()
                .accessToken("Bla bla bla")
                .build();
    }
}
