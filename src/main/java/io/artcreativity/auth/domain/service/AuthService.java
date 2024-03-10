package io.artcreativity.auth.domain.service;

import io.swagger.v3.oas.models.responses.ApiResponse;

public interface AuthService {
    ApiResponse registerUser(UserDto userDto);
    JwtAuthenticationResponse authenticateUser(JwtAuthenticationRequest authenticationRequest);
    JwtAuthenticationResponse refreshToken(String token);
    ApiResponse passwordResetRequest(String email);
    ApiResponse checkToken(String type, String token);
}
