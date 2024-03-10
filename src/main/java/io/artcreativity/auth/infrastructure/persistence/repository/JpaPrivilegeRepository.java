package io.artcreativity.auth.infrastructure.persistence.repository;

import io.artcreativity.auth.infrastructure.persistence.entities.JpaPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPrivilegeRepository extends JpaRepository<JpaPrivilege, Long> {
}
