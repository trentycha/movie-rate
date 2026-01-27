package com.example.movie_rate.repositories;

import com.example.movie_rate.models.Notation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotationRepository extends JpaRepository<Notation, Integer> {

}
