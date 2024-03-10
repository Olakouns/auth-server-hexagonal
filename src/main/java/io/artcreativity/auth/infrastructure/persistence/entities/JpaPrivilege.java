package io.artcreativity.auth.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.artcreativity.auth.domain.model.entities.TypePrivilege;
import io.artcreativity.auth.domain.model.entities.TypeRole;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Collection;

@NoArgsConstructor
@Entity
@Table(name = "privileges")
@SQLDelete(sql =
        "UPDATE privileges " +
                "SET deleted = true " +
                "WHERE id = ?")
@Where(clause = "deleted = false")
public class JpaPrivilege extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypePrivilege name;
    private String description;
    private String category;
    private TypeRole typeRole;

    @ManyToMany(mappedBy = "privileges")
    @JsonIgnore
    private Collection<JpaRole> roles;

    public JpaPrivilege(TypePrivilege name) {
        super();
        this.name = name;
    }

    public JpaPrivilege(String category, TypePrivilege name, String description, TypeRole typeRole) {
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

    public Collection<JpaRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<JpaRole> roles) {
        this.roles = roles;
    }

    public TypeRole getTypeRole() {
        return typeRole;
    }

    public void setTypeRole(TypeRole typeRole) {
        this.typeRole = typeRole;
    }
}
