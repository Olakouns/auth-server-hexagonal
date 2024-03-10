package io.artcreativity.auth.infrastructure.adapter;

import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.domain.model.entities.UserCompany;
import io.artcreativity.auth.domain.port.UserCompanyPort;
import io.artcreativity.auth.infrastructure.persistence.mapper.JpaUserCompanyMapper;
import io.artcreativity.auth.infrastructure.persistence.mapper.JpaUserMapper;
import io.artcreativity.auth.infrastructure.persistence.repository.JpaUserCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserCompanyAdapter implements UserCompanyPort {

    private final JpaUserCompanyRepository jpaUserCompanyRepository;
    private final JpaUserCompanyMapper jpaUserCompanyMapper;
    private final JpaUserMapper jpaUserMapper;

    @Override
    public boolean existsByUserAndCompanyId(User user, UUID companyId) {
        return jpaUserCompanyRepository.existsByUserAndCompanyId(jpaUserMapper.toJpaUser(user), companyId);
    }

    @Override
    public UserCompany findByUserAndCompanyId(User user, UUID companyId) {
        return jpaUserCompanyMapper.toUserCompany(jpaUserCompanyRepository.findByUserAndCompanyId(jpaUserMapper.toJpaUser(user), companyId));
    }

    @Override
    public UserCompany save(UserCompany userCompany) {
        return jpaUserCompanyMapper.toUserCompany(jpaUserCompanyRepository.save(jpaUserCompanyMapper.toJpaUserCompany(userCompany)));
    }
}
