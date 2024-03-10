package io.artcreativity.auth.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class UserCompany extends BaseEntity {
    private UUID id;
    private User user;
    private UUID companyId;
    private Role role;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
