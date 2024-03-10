package io.artcreativity.auth.infrastructure.persistence.repository;

import io.artcreativity.auth.infrastructure.persistence.entities.JpaUser;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaUserCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaUserCompanyRepository extends JpaRepository<JpaUserCompany, UUID> {
    List<JpaUserCompany> findByUser(JpaUser user);
    JpaUserCompany findByUserAndCompanyId(JpaUser user, UUID company);
    boolean existsByUserAndCompanyId(JpaUser profile_user, UUID company);
}
