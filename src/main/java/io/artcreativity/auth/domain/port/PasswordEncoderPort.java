package io.artcreativity.auth.domain.port;

import io.artcreativity.auth.common.JwtAuthenticationResponse;
import io.artcreativity.auth.domain.model.entities.User;

public interface PasswordEncoderPort {
    String encode(String password);
}
