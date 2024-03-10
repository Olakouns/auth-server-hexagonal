package io.artcreativity.auth.domain.model.entities;

import java.time.Instant;

public abstract class BaseEntity {
    private static final long serialVersionUID = 5577146783938089893L;
    private boolean deleted;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean canBeDeleted = true;
    private User createdBy;
    private User modifiedBy;
    private String slug;
}
