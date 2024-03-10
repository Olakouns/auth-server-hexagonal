package io.artcreativity.auth.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.artcreativity.auth.domain.model.entities.TypeRole;
import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class JpaRole implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5611760913680161176L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private TypeRole role;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Set<JpaPrivilege> privileges;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonIgnore
    private JpaUser createdBy;

    private UUID companyId;

    public JpaRole() {
        super();
        // TODO Auto-generated constructor stub
    }

    public JpaRole(String name, TypeRole role) {
        super();
        this.name = name;
        this.role = role;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the role
     */
    public TypeRole getRole() {
        return role;
    }
    /**
     * @param role the role to set
     */
    public void setRole(TypeRole role) {
        this.role = role;
    }

    @JsonIgnore
    public Set<JpaPrivilege> getPrivileges() {
        return privileges;
    }

    @JsonSetter
    public void setPrivileges(Set<JpaPrivilege> privileges) {
        this.privileges = privileges;
    }

    public JpaUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(JpaUser createdBy) {
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }
}
