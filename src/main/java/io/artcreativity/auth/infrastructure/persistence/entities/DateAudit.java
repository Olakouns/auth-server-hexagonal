package io.artcreativity.auth.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true,
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)

public abstract class DateAudit implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5577146783938089893L;

    @JsonIgnore
    @ColumnDefault(value = "false")
    private boolean deleted;
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant createdAt;
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant updatedAt;
    @Transient
    private boolean canBeDeleted = true;
    @CreatedBy
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private JpaUser createdBy;
    @LastModifiedBy
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private JpaUser modifiedBy;
    @Column(unique = true)
    private String slug;

    /**
     *
     */
    public DateAudit() {
        super();
    }

    /**
     * @param createdAt
     * @param updatedAt
     */
    public DateAudit(Instant createdAt, Instant updatedAt) {
        super();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //	@JsonSerialize(using = CustomDateSerializer.class)
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    //	@JsonSerialize(using = CustomDateSerializer.class)
    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    //	@PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

    //	@PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

    public boolean isCanBeDeleted() {
        return canBeDeleted;
    }

    public void setCanBeDeleted(boolean canBeDeleted) {
        this.canBeDeleted = canBeDeleted;
    }

    public JpaUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(JpaUser createdBy) {
        this.createdBy = createdBy;
    }

    public JpaUser getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(JpaUser modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }


}
