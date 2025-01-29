package com.topcv.topcvserver.controllers;

import com.topcv.topcvserver.models.LoginRequest;
import com.topcv.topcvserver.models.LoginResponse;
import com.topcv.topcvserver.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // Login endpoint
    @PostMapping("/api/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) { // still need to set up validation
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }
}
