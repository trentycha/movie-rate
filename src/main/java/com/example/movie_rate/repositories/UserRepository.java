package com.example.movie_rate.repositories;

import com.example.movie_rate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    Optional<User> findById(Integer id);

    List<User> findByRolesId(Integer id);
}



