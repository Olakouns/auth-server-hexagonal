package io.artcreativity.auth.domain.port;

import io.artcreativity.auth.domain.model.entities.Profile;
import io.artcreativity.auth.domain.model.entities.User;

import java.util.Optional;

public interface ProfilePort {
    Optional<Profile> findByUser(User save);

    Profile save(Profile profile);

    boolean existsByEmail(String email);
}
