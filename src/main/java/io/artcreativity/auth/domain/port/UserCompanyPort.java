package io.artcreativity.auth.domain.port;

import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.domain.model.entities.UserCompany;

import java.util.UUID;

public interface UserCompanyPort {
    boolean existsByUserAndCompanyId(User save, UUID companyId);

    UserCompany findByUserAndCompanyId(User save, UUID companyId);

    UserCompany save(UserCompany userCompany);
}
