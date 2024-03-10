package io.artcreativity.auth.infrastructure.adapter;

import io.artcreativity.auth.common.JwtAuthenticationResponse;
import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.domain.port.PasswordEncoderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordEncoderAdapter implements PasswordEncoderPort {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
