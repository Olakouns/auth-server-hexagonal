package io.artcreativity.auth;

import io.artcreativity.auth.domain.model.entities.User;
import io.artcreativity.auth.infrastructure.persistence.entities.JpaUser;
import io.artcreativity.auth.infrastructure.persistence.mapper.JpaUserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

@SpringBootTest
class AuthAppsApplicationTests {

    @Autowired
    private JpaUserMapper jpaUserMapper ;

    @Test
    void contextLoads() {
    }

    @Test
    void testMapping() {
        JpaUser jpaUser = new JpaUser();
        jpaUser.setCreatedAt(Instant.now());
        jpaUser.setModifiedBy(new JpaUser());
        jpaUser.setSlug("olakouns");

        User user = jpaUserMapper.toUser(jpaUser);
        System.out.println(user);
        Assertions.assertNotNull(user.getCreatedAt());
    }

}
