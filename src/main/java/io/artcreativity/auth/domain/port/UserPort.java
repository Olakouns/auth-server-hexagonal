package io.artcreativity.auth.domain.port;

import io.artcreativity.auth.domain.model.entities.User;

import java.util.Map;
import java.util.Optional;

public interface UserPort {
    boolean existsByEmail(String email);

    boolean existsByEmailAndActive(String email, boolean active);

    Optional<User> findByEmail(String email);

    User save(User save);
}
