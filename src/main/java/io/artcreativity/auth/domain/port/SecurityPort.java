package io.artcreativity.auth.domain.port;

import io.artcreativity.auth.common.JwtAuthenticationResponse;
import io.artcreativity.auth.domain.model.entities.User;

public interface SecurityPort {
    JwtAuthenticationResponse getTokens(String username);
    JwtAuthenticationResponse loginUser(User user, String username, String password);
}
