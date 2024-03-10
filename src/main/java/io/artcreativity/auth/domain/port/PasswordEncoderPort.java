package io.artcreativity.auth.domain.port;

public interface PasswordEncoderPort {
    String encode(String password);
}
