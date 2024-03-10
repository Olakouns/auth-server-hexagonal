package io.artcreativity.auth.domain.service;

import io.artcreativity.auth.domain.model.entities.User;

import java.util.Map;
import java.util.UUID;

public interface AuthService {
    Map<String, String> createUser(User user, UUID companyId);

    String getJwtToken(String username, String password);

    String getJwtRefreshToken(String username, String password);

    String getRefreshToken(String accessToken);

    boolean sendEmailForgotPassword(String email);

    boolean checkedToken(String type, String token);

    boolean changedPassword(String token, String email, String password, String confirmPassword);

    boolean setNewPassword(String token, String email, String password, String confirmPassword);
}
