package io.artcreativity.auth.application.controller;

import io.artcreativity.auth.application.dto.ApiResponse;
import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.domain.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Create a new user for a company")
    public ApiResponse createUser(@RequestBody User user, @RequestHeader("company") UUID companyId) {
        Map<String, String> response = authService.createUser(user, companyId);
        return new ApiResponse(Boolean.valueOf(response.get("status")), response.get("message"));
    }
}
