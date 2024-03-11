package io.artcreativity.auth.infrastructure.adapter;

import io.artcreativity.auth.common.JwtAuthenticationResponse;
import io.artcreativity.auth.domain.exceptions.ResourceNotFoundException;
import io.artcreativity.auth.domain.model.entities.StatusUser;
import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.domain.port.SecurityPort;
import io.artcreativity.auth.infrastructure.exceptions.NoAuthorizationException;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaUser;
import io.artcreativity.auth.infrastructure.persistence.mapper.JpaUserMapper;
import io.artcreativity.auth.infrastructure.persistence.repository.JpaUserRepository;
import io.artcreativity.auth.infrastructure.security.TokenAuthentificationProvider;
import io.artcreativity.auth.infrastructure.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityAdapter implements SecurityPort {
    private final TokenAuthentificationProvider tokenProvider;
    private final JpaUserRepository jpaUserRepository;
    private final JpaUserMapper jpaUserMapper;
    private final AuthenticationManager authenticationManager;


    @Override
    public JwtAuthenticationResponse getTokens(String username) {
        JpaUser user = jpaUserRepository.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException("User", "username", username)
        );
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        return tokenProvider.generateToken(userPrincipal);
    }

    @Override
    public JwtAuthenticationResponse loginUser(User user, String username, String password) {
        JpaUser jpaUser = jpaUserMapper.toJpaUser(user);

        System.out.println(username);
        System.out.println(password);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        if (jpaUser.getStatus() == StatusUser.SUSPENDED) {
            throw new NoAuthorizationException("Votre compte a été suspendu. Vous n'etes pas autorisé à accéder à cette plateforme.");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return tokenProvider.generateToken(authentication);
    }


}
