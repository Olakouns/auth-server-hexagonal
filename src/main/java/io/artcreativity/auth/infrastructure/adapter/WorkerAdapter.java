package io.artcreativity.auth.infrastructure.adapter;

import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.domain.model.entities.Worker;
import io.artcreativity.auth.domain.port.WorkerPort;
import io.artcreativity.auth.infrastructure.persistence.mapper.JpaUserMapper;
import io.artcreativity.auth.infrastructure.persistence.mapper.JpaWorkerMapper;
import io.artcreativity.auth.infrastructure.persistence.repository.JpaWorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WorkerAdapter implements WorkerPort {
    private final JpaWorkerRepository jpaWorkerRepository;
    private final JpaWorkerMapper jpaWorkerMapper;
    private final JpaUserMapper jpaUserMapper;

    @Override
    public Optional<Worker> findByUser(User user) {
        return jpaWorkerRepository.findByUser(jpaUserMapper.toJpaUser(user)).map(jpaWorkerMapper::toWorker);
    }

    @Override
    public Worker save(Worker profile) {
        return jpaWorkerMapper.toWorker(jpaWorkerRepository.save(jpaWorkerMapper.toJpaWorker(profile)));
    }
}
