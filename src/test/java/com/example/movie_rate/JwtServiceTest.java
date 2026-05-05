package com.example.movie_rate;

import Services.JwtService;
import com.example.movie_rate.models.Roles;
import com.example.movie_rate.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {

    private JwtService jwtService;
    private User user;

    @BeforeEach
    void setUp() {
        jwtService = new JwtService();
        ReflectionTestUtils.setField(jwtService, "jwt", "unesecretcletreslonguepourletestjwths256minimum32chars!");
        ReflectionTestUtils.setField(jwtService, "expiration", 86400000L);

        Roles role = new Roles();
        role.setLabel("ROLE_USER");

        user = new User();
        user.setUsername("charlene");
        user.setMail("charlene@test.fr");
        user.setRoles(role);
    }

    @Test
    void generateToken_shouldReturnNonEmptyToken() {
        String token = jwtService.generateToken(user);
        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    void extractEmail_shouldReturnCorrectEmail() {
        String token = jwtService.generateToken(user);
        String email = jwtService.extractEmail(token);
        assertEquals("charlene@test.fr", email);
    }

    @Test
    void isTokenExpired_shouldReturnFalseForFreshToken() {
        String token = jwtService.generateToken(user);
        assertFalse(jwtService.isTokenExpired(token));
    }

    @Test
    void isTokenExpired_shouldThrowForExpiredToken() {
        ReflectionTestUtils.setField(jwtService, "expiration", -1000L);
        String token = jwtService.generateToken(user);
        assertThrows(Exception.class, () -> jwtService.isTokenExpired(token));
    }
}