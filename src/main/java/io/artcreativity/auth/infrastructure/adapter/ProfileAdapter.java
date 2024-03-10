package io.artcreativity.auth.infrastructure.adapter;

import io.artcreativity.auth.domain.model.entities.Profile;
import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.domain.port.ProfilePort;
import io.artcreativity.auth.infrastructure.persistence.mapper.JpaUserMapper;
import io.artcreativity.auth.infrastructure.persistence.mapper.JpaProfileMapper;
import io.artcreativity.auth.infrastructure.persistence.repository.JpaProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProfileAdapter implements ProfilePort {
    private final JpaProfileRepository jpaProfileRepository;
    private final JpaProfileMapper jpaWorkerMapper;
    private final JpaUserMapper jpaUserMapper;

    @Override
    public Optional<Profile> findByUser(User user) {
        return jpaProfileRepository.findByUser(jpaUserMapper.toJpaUser(user)).map(jpaWorkerMapper::toProfile);
    }

    @Override
    public Profile save(Profile profile) {
        return jpaWorkerMapper.toProfile(jpaProfileRepository.save(jpaWorkerMapper.toJpaProfile(profile)));
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaProfileRepository.existsByEmail(email);
    }
}
