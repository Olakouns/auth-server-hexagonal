package io.artcreativity.auth.infrastructure.configuration;

import io.artcreativity.auth.domain.port.*;
import io.artcreativity.auth.domain.service.DomainAuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public DomainAuthService domainAuthService(final UserPort userPort, final ProfilePort workerPort, final RolePort rolePort, final SecurityPort securityPort, final PasswordEncoderPort passwordEncoderPort) {
        return new DomainAuthService(userPort, workerPort, rolePort, securityPort, passwordEncoderPort);
    }
}
