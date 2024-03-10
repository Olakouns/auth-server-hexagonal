package io.artcreativity.auth.infrastructure.persistence.mapper;


import io.artcreativity.auth.domain.model.entities.Role;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaRole;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface JpaRoleMapper {
    JpaRoleMapper INSTANCE = Mappers.getMapper(JpaRoleMapper.class);
    Role toRole(JpaRole role);
    JpaRole toJpaRole(Role role);
}
