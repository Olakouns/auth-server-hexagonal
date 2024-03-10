package io.artcreativity.auth.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.artcreativity.auth.domain.model.entities.StatusUser;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JpaUser extends DateAudit {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;
    //	@Size(max = 40)
    private String name;
    @NotBlank
//	@Size(max = 40)
    @Column(unique = true)
    private String username;
    @Email
    private String email;
    @NotBlank
    @Size(max = 100)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role_id"})}
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Collection<JpaRole> roles = new ArrayList<>();
    @ColumnDefault(value = "false")
    private boolean active;
    @Enumerated(EnumType.STRING)
    private StatusUser status;
    @ColumnDefault(value = "false")
    @Column(nullable = true)
    @JsonIgnore
    private boolean defaultPassword;
    @Transient
    private JpaRole role;
}
