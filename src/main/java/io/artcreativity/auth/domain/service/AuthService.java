package io.artcreativity.auth.domain.service;

import io.artcreativity.auth.common.JwtAuthenticationResponse;
import io.artcreativity.auth.domain.model.entities.Profile;
import io.artcreativity.auth.domain.model.entities.User;

import java.util.Map;
import java.util.UUID;

public interface AuthService {
    Profile createUser(Profile profile);

    JwtAuthenticationResponse getTokens(User user);

    JwtAuthenticationResponse loginUser(String username, String password);

    boolean sendEmailForgotPassword(String email);

    boolean checkedToken(String type, String token);

    boolean changedPassword(String token, String email, String password, String confirmPassword);

    boolean setNewPassword(String token, String email, String password, String confirmPassword);
}
