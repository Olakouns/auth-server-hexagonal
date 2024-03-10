package io.artcreativity.auth.domain.model.entities;

import java.util.Collection;


public class Privilege extends BaseEntity {

    private Long id;
    private TypePrivilege name;
    private String description;
    private String category;
    private TypeRole typeRole;

    private Collection<Role> roles;

    public Privilege(TypePrivilege name) {
        super();
        this.name = name;
    }

    public Privilege(String category, TypePrivilege name, String description, TypeRole typeRole) {
        super();
        this.category = category;
        this.name = name;
        this.description = description;
        this.typeRole = typeRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypePrivilege getName() {
        return name;
    }

    public void setName(TypePrivilege name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public TypeRole getTypeRole() {
        return typeRole;
    }

    public void setTypeRole(TypeRole typeRole) {
        this.typeRole = typeRole;
    }
}
