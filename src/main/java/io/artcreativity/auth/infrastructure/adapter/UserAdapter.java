package io.artcreativity.auth.infrastructure.adapter;

import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.domain.port.UserPort;
import io.artcreativity.auth.infrastructure.persistence.mapper.JpaUserMapper;
import io.artcreativity.auth.infrastructure.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserAdapter implements UserPort {

    private final JpaUserRepository jpaUserRepository;
    private final JpaUserMapper jpaUserMapper;

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByEmailAndActive(String email, boolean active) {
        return jpaUserRepository.existsByEmailAndActive(email, active);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email).map(jpaUserMapper::toUser);
    }

    @Override
    public Optional<User> findByUsername(String email) {
        return jpaUserRepository.findByUsername(email).map(jpaUserMapper::toUser);
    }

    @Override
    public Optional<User> findByUsernameOrEmail(String email) {
        return jpaUserRepository.findByUsernameOrEmail(email, email).map(jpaUserMapper::toUser);
    }

    @Override
    public User save(User save) {
        return jpaUserMapper.toUser(jpaUserRepository.save(jpaUserMapper.toJpaUser(save)));
    }
}
