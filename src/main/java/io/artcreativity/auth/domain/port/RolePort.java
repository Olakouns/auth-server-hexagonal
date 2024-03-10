package io.artcreativity.auth.domain.port;

import io.artcreativity.auth.domain.model.entities.Role;
import io.artcreativity.auth.domain.model.entities.TypeRole;

import java.util.List;

public interface RolePort {
    List<Role> findByRole(TypeRole typeRole);
}
