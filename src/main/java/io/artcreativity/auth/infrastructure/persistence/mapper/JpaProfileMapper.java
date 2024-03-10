package io.artcreativity.auth.infrastructure.persistence.mapper;

import io.artcreativity.auth.domain.model.entities.Profile;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaProfile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {JpaUserMapper.class})
public interface JpaProfileMapper {
    JpaProfile INSTANCE = Mappers.getMapper(JpaProfile.class);
    JpaProfile toJpaProfile(Profile worker);
    Profile toProfile(JpaProfile jpaProfile);
}
