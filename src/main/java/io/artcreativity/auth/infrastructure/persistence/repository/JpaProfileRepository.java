package io.artcreativity.auth.infrastructure.persistence.repository;

import io.artcreativity.auth.infrastructure.persistence.entities.JpaProfile;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaProfileRepository extends JpaRepository<JpaProfile, UUID> {
    Optional<JpaProfile> findByUser(JpaUser user);

    boolean existsByEmail(String email);
}
