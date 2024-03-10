package io.artcreativity.auth.infrastructure.persistence.mapper;

import io.artcreativity.auth.domain.model.entities.Worker;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaWorker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {JpaUserMapper.class})
public interface JpaWorkerMapper {
    JpaWorker INSTANCE = Mappers.getMapper(JpaWorker.class);
    JpaWorker toJpaWorker(Worker worker);
    Worker toWorker(JpaWorker jpaWorker);
}
