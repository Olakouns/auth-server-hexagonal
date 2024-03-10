package io.artcreativity.auth.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "user_companies")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JpaUserCompany extends DateAudit {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private JpaUser user;
    private UUID companyId;
    @ManyToOne
    @JoinColumn
    private JpaRole role;
}