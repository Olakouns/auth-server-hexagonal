package io.artcreativity.auth.domain.port;

import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.domain.model.entities.Worker;

import java.util.Optional;

public interface WorkerPort {
    Optional<Worker> findByUser(User save);

    Worker save(Worker profile);
}
