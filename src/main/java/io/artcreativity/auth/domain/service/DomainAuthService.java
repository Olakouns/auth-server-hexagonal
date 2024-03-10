package io.artcreativity.auth.domain.service;

import io.artcreativity.auth.domain.model.entities.*;
import io.artcreativity.auth.domain.port.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DomainAuthService implements AuthService {

    private final UserPort userPort;
    private final UserCompanyPort userCompanyPort;
    private final WorkerPort workerPort;
    private final RolePort rolePort;

    private final PasswordEncoderPort passwordEncoderPort;

    public DomainAuthService(UserPort userPort, UserCompanyPort userCompanyPort, WorkerPort workerPort, RolePort rolePort, PasswordEncoderPort passwordEncoderPort) {
        this.userPort = userPort;
        this.userCompanyPort = userCompanyPort;
        this.workerPort = workerPort;
        this.rolePort = rolePort;
        this.passwordEncoderPort = passwordEncoderPort;
    }

    @Override
    public Map<String, String> createUser(User user, UUID companyId) {
        Role roleCompany = new ArrayList<>(user.getRoles()).get(0);
        User save;
        UserCompany userCompany;
        if (userPort.existsByEmail(user.getEmail())) {
            if (userPort.existsByEmailAndActive(user.getEmail(), false)) {
                save = userPort.findByEmail(user.getEmail()).get();
                if (userCompanyPort.existsByUserAndCompanyId(save, companyId)) {
                    userCompany = userCompanyPort.findByUserAndCompanyId(save, companyId);
                } else {
                    userCompany = new UserCompany();
                }
            } else {
                return new HashMap<>() {
                    {
                        put("status", "false");
                        put("message", "Un utilisateur utilisant l'email " + user.getEmail() + " existe deja");
                    }
                };
            }
        } else {
            save = user;
            userCompany = new UserCompany();
        }

        save.setPassword(passwordEncoderPort.encode(user.getPassword()));
        save.setRoles(new ArrayList<>(rolePort.findByRole(TypeRole.ROLE_SIMPLE)));
        save.setActive(true);
        save.setStatus(StatusUser.ACTIVE);
        save = userPort.save(save);
        Worker profile;
        profile = workerPort.findByUser(save).orElse(new Worker());
        profile.setUser(save);
        profile.setEmail(save.getEmail());
        profile.setUsername(save.getEmail());
        profile.setFirstName(user.getName());
        profile = workerPort.save(profile);

        userCompany.setUser(save);
        userCompany.setCompanyId(companyId);
        userCompany.setRole(roleCompany);
        userCompanyPort.save(userCompany);

        Worker finalProfile = profile;
        return new HashMap<>() {
            {
                put("status", "true");
                put("message", finalProfile.getId().toString());
            }
        };
    }

    @Override
    public String getJwtToken(String username, String password) {
        return null;
    }

    @Override
    public String getJwtRefreshToken(String username, String password) {
        return null;
    }

    @Override
    public String getRefreshToken(String accessToken) {
        return null;
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
