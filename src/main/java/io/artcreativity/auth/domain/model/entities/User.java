package io.artcreativity.auth.domain.model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class User extends BaseEntity {
    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Collection<Role> roles = new ArrayList<>();
    private StatusUser status;
    private boolean defaultPassword;
    private Role role;
}
