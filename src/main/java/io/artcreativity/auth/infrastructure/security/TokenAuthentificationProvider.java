package io.artcreativity.auth.infrastructure.security;

import io.artcreativity.auth.common.JwtAuthenticationResponse;
import io.artcreativity.auth.domain.exceptions.ResourceNotFoundException;
import io.artcreativity.auth.infrastructure.exceptions.NoAuthorizationException;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaUser;
import io.artcreativity.auth.infrastructure.persistence.repository.JpaUserRepository;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TokenAuthentificationProvider {

    private static final Logger logger = LoggerFactory.getLogger(TokenAuthentificationProvider.class);

    @Value("${kyubi.jwtSecret}")
    private String jwtSecret;
    @Value("${jwt.jwtRefreshSecret}")
    private String jwtRefreshSecret;

    @Value("${kyubi.jwtExpirationInMs}")
    private int jwtExpirationInMs;
    @Value("${jwt.jwtRefreshExpirationInMs}")
    private long jwtRefreshExpirationInMs;
    private final JpaUserRepository userRepository;

    public TokenAuthentificationProvider(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public JwtAuthenticationResponse generateToken(Authentication authentication) {
        return generateToken((UserPrincipal) authentication.getPrincipal());
    }

    public JwtAuthenticationResponse generateToken(UserPrincipal userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        Date refreshExpiryDate = new Date(now.getTime() + jwtRefreshExpirationInMs);

        Map<String, Object> claims = new HashMap<>();
        List<String> roles = new ArrayList<>();
        userDetails.getAuthorities().forEach(role -> {
            roles.add(role.getAuthority());
        });
        claims.put("roles", roles.toArray(new String[roles.size()]));

        // JWT for permission
        String tokenPermission = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
                .compact();

        String token = Jwts.builder()
                .setSubject(userDetails.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
                .compact();


        // JWT for refresh token
        Map<String, Object> claimsRefresh = new HashMap<>();
        String accessToken = Jwts.builder()
                .setClaims(claimsRefresh)
                .setSubject(userDetails.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(refreshExpiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtRefreshSecret.getBytes())
                .compact();

        return new JwtAuthenticationResponse(token, accessToken, expiryDate, tokenPermission);
    }

    public String getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret.getBytes())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        return validateJWT(authToken, jwtSecret);
    }

    private boolean validateJWT(String authToken, String jwtSecret) {
        try {
            Jwts.parser().setSigningKey(jwtSecret.getBytes()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

    public JwtAuthenticationResponse refreshToken(String accessToken) {
        if(!validateAccessToken(accessToken)){
            throw new NoAuthorizationException("Sorry, You're not authorized to access this resource.");
        }
        String userId = getUserIdFromRefreshJWT(accessToken);
        JpaUser user = userRepository.findById(UUID.fromString(userId)).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );
        UserPrincipal userP = UserPrincipal.create(user);
        return generateToken(userP);

    }

    public String getUserIdFromRefreshJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtRefreshSecret.getBytes())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateAccessToken(String authToken) {
        return validateJWT(authToken, jwtRefreshSecret);
    }
}
