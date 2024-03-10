package io.artcreativity.auth.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class UserCompany extends BaseEntity {
    private UUID id;
    private User user;
    private UUID companyId;
    private Role role;
}
