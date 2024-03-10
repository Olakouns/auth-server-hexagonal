package io.artcreativity.auth.infrastructure.persistence.repository;

import io.artcreativity.auth.infrastructure.persistence.entities.JpaUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<JpaUser, UUID> {
    Optional<JpaUser> findByUsername(String username);

    Optional<JpaUser> findByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByEmailAndActive(String email, boolean active);

    Page<JpaUser> findByRoles_id(int idRole, Pageable page);

    Page<JpaUser> findByRoles_idIn(int[] idRole, Pageable page);

    Page<JpaUser> findByNameLike(String keyword1, Pageable page);

    Optional<JpaUser> findByUsernameOrEmail(String username, String email);
}
