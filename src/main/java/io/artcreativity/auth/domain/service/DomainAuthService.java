package io.artcreativity.auth.domain.service;

import io.artcreativity.auth.common.JwtAuthenticationResponse;
import io.artcreativity.auth.domain.exceptions.RequestNotAcceptableException;
import io.artcreativity.auth.domain.exceptions.ResourceNotFoundException;
import io.artcreativity.auth.domain.model.entities.*;
import io.artcreativity.auth.domain.port.*;

import java.util.ArrayList;
import java.util.List;

public class DomainAuthService implements AuthService {

    private final UserPort userPort;
    private final ProfilePort profilePort;
    private final RolePort rolePort;
    private final SecurityPort securityPort;

    private final PasswordEncoderPort passwordEncoderPort;

    public DomainAuthService(UserPort userPort, ProfilePort profilePort, RolePort rolePort, SecurityPort securityPort, PasswordEncoderPort passwordEncoderPort) {
        this.userPort = userPort;
        this.profilePort = profilePort;
        this.rolePort = rolePort;
        this.securityPort = securityPort;
        this.passwordEncoderPort = passwordEncoderPort;
    }

    @Override
    public Profile createUser(Profile profile) {
        if (profilePort.existsByEmail(profile.getEmail())) {
            System.out.println("ICI exist deja");
            throw new RequestNotAcceptableException("Il y a déjà un compte associé à cette adresse e-mail");
        }

        User user = profile.getUser();
        List<Role> roles = new ArrayList<>();
        roles.add(rolePort.findFirstByRole(TypeRole.ROLE_SIMPLE));
        user.setRoles(roles);
        user.setPassword(passwordEncoderPort.encode(user.getPassword()));
        user.setActive(true);
        user.setStatus(StatusUser.ACTIVE);
        user.setDefaultPassword(false);
        user.setName(profile.getLastName() + " " + profile.getFirstName());
        System.out.println("ICI");
        user = userPort.save(user);

        profile.setUser(user);
        return profilePort.save(profile);
    }

    @Override
    public JwtAuthenticationResponse getTokens(User user) {
        return securityPort.getTokens(user.getUsername());
    }

    @Override
    public JwtAuthenticationResponse loginUser(String username, String password) {
        User user = userPort.findByUsernameOrEmail(username).orElseThrow(
                () -> new ResourceNotFoundException("User", "username", username)
        );
        return securityPort.loginUser(user, username, password);
    }

    @Override
    public boolean sendEmailForgotPassword(String email) {
        return false;
    }

    @Override
    public boolean checkedToken(String type, String token) {
        return false;
    }

    @Override
    public boolean changedPassword(String token, String email, String password, String confirmPassword) {
        return false;
    }

    @Override
    public boolean setNewPassword(String token, String email, String password, String confirmPassword) {
        return false;
    }
}
