package io.artcreativity.auth.infrastructure.persistence.mapper;


import io.artcreativity.auth.domain.model.entities.Privilege;
import io.artcreativity.auth.domain.model.entities.Role;
import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaPrivilege;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaRole;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaUser;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
@Mapper(componentModel = "spring")
public interface JpaRoleMapper {
    JpaRoleMapper INSTANCE = Mappers.getMapper(JpaRoleMapper.class);

    @Mapping(target = "createdBy.roles", ignore = true)
    @Mapping(target = "createdBy.role", ignore = true)
    Role toRole(JpaRole role);

    JpaRole toJpaRole(Role role);

    @Mapping(target = "roles", ignore = true)
    Privilege jpaPrivilegeToPrivilege(JpaPrivilege jpaPrivilege);
}
