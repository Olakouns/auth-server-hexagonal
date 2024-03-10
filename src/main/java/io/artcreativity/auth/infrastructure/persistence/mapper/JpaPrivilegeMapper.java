package io.artcreativity.auth.infrastructure.persistence.mapper;

import io.artcreativity.auth.domain.model.entities.Privilege;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaPrivilege;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface JpaPrivilegeMapper {
    JpaPrivilegeMapper INSTANCE = Mappers.getMapper(JpaPrivilegeMapper.class);

    Privilege toPrivilege(JpaPrivilege jpaPrivilege);

    JpaPrivilege toJpaPrivilege(Privilege privilege);
}
