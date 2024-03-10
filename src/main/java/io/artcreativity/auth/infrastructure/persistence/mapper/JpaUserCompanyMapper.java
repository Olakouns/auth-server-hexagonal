package io.artcreativity.auth.infrastructure.persistence.mapper;

import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.domain.model.entities.UserCompany;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaUser;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaUserCompany;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {JpaRoleMapper.class, JpaUserMapper.class})
public interface JpaUserCompanyMapper {
    JpaUserCompanyMapper INSTANCE = Mappers.getMapper(JpaUserCompanyMapper.class);

    JpaUserCompany toJpaUserCompany(UserCompany userCompany);

    UserCompany toUserCompany(JpaUserCompany jpaUserCompany);

}
