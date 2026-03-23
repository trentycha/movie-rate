package com.example.movie_rate.Controllers;

import Services.JwtService;
import Services.UserService;
import com.example.movie_rate.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @GetMapping("/${id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Integer  id) {
        Optional<User> user = UserService.getUserById(id);
        return ResponseEntity.ok(user);
    }

}
