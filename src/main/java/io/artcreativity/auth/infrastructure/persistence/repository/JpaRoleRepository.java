package io.artcreativity.auth.infrastructure.persistence.repository;

import io.artcreativity.auth.domain.model.entities.TypeRole;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRoleRepository extends JpaRepository<JpaRole, Integer> {
    List<JpaRole> findByRole(TypeRole type);

    JpaRole findFirstByRole(TypeRole typeRole);
}
