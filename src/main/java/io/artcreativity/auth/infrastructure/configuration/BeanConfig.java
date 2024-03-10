package io.artcreativity.auth.infrastructure.configuration;

import io.artcreativity.auth.domain.port.*;
import io.artcreativity.auth.domain.service.DomainAuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public DomainAuthService domainAuthService(final UserPort userPort, final UserCompanyPort userCompanyPort, final WorkerPort workerPort, final RolePort rolePort, final PasswordEncoderPort passwordEncoderPort) {
        return new DomainAuthService(userPort, userCompanyPort, workerPort, rolePort, passwordEncoderPort);
    }
}
