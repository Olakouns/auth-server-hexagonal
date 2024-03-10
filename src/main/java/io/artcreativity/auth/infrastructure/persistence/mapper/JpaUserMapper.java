package io.artcreativity.auth.infrastructure.persistence.mapper;

import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {JpaRoleMapper.class, JpaPrivilegeMapper.class}, componentModel = "spring")
public interface JpaUserMapper {
    JpaUserMapper INSTANCE = Mappers.getMapper(JpaUserMapper.class);
    User toUser(JpaUser jpaUser);
    JpaUser toJpaUser(User user);
}
