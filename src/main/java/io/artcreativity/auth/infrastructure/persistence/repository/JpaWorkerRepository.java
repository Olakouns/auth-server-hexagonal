package io.artcreativity.auth.infrastructure.persistence.repository;

import io.artcreativity.auth.infrastructure.persistence.entities.JpaUser;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaWorker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaWorkerRepository extends JpaRepository<JpaWorker, UUID> {
    Optional<JpaWorker> findByUser(JpaUser user);
}
