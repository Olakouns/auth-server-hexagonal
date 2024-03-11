package io.artcreativity.auth.application.controller;

import io.artcreativity.auth.application.dto.ApiResponse;
import io.artcreativity.auth.common.JwtAuthenticationResponse;
import io.artcreativity.auth.domain.model.entities.Profile;
import io.artcreativity.auth.domain.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Create a new user", description = "Create a new user in the system.")
    public ApiResponse createUser(@RequestBody Profile profile) {
        Profile response = authService.createUser(profile);
        return new ApiResponse(true, "User created successfully with id: " + response.getUser().getId());
    }

    @PostMapping("/register-and-get-token")
    @Operation(summary = "Create a new user and get token", description = "Create user and automatically get token.")
    public JwtAuthenticationResponse createUserAndGetToken(@RequestBody Profile profile) {
        String username = profile.getUser().getUsername();
        String password = profile.getUser().getPassword();
        authService.createUser(profile);
        return authService.loginUser(username, password);
    }
}
