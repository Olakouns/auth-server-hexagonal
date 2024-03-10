package io.artcreativity.auth.domain.model.entities;

import java.io.Serializable;
import java.util.Set;


public class Role implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5611760913680161176L;
    private Integer id;
    private String name;

    private TypeRole role;
    private Set<Privilege> privileges;
    private User createdBy;

    public Role() {
        super();
    }

    public Role(String name, TypeRole role) {
        super();
        this.name = name;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeRole getRole() {
        return role;
    }

    public void setRole(TypeRole role) {
        this.role = role;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
