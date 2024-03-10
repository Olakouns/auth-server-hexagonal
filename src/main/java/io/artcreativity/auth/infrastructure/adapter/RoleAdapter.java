package io.artcreativity.auth.infrastructure.adapter;

import io.artcreativity.auth.domain.model.entities.Role;
import io.artcreativity.auth.domain.model.entities.TypeRole;
import io.artcreativity.auth.domain.port.RolePort;
import io.artcreativity.auth.infrastructure.persistence.mapper.JpaRoleMapper;
import io.artcreativity.auth.infrastructure.persistence.repository.JpaRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleAdapter implements RolePort {

    private final JpaRoleRepository jpaRoleRepository;
    private final JpaRoleMapper jpaRoleMapper;

    @Override
    public List<Role> findByRole(TypeRole typeRole) {
        return jpaRoleRepository.findByRole(typeRole).stream().map(jpaRoleMapper::toRole).toList();
    }
}
