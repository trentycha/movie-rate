package com.example.movie_rate;

import Services.UserService;
import com.example.movie_rate.models.Roles;
import com.example.movie_rate.models.User;
import com.example.movie_rate.repositories.RolesRepository;
import com.example.movie_rate.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RolesRepository rolesRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void register_shouldSucceed_whenEmailIsNotTaken() {
        Roles role = new Roles();
        role.setLabel("ROLE_USER");

        when(userRepository.existsByEmail("nouveau@test.fr")).thenReturn(false);
        when(passwordEncoder.encode("password123")).thenReturn("hashedpassword");
        when(rolesRepository.findByName("ROLE_USER")).thenReturn(Optional.of(role));
        when(userRepository.save(any(User.class))).thenReturn(new User());

        assertDoesNotThrow(() -> userService.register("charlene", "nouveau@test.fr", "password123"));
    }

    @Test
    void register_shouldThrowException_whenEmailAlreadyExists() {
        when(userRepository.existsByEmail("existant@test.fr")).thenReturn(true);
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                userService.register("charlene", "existant@test.fr", "password123")
        );
        assertEquals("Email invalide. Déjà utilisé par un utilisateur.", exception.getMessage());
    }
}