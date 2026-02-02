package com.example.movie_rate.repositories;

import com.example.movie_rate.models.Country;
import com.example.movie_rate.models.Film;
import com.example.movie_rate.models.Notation;
import com.example.movie_rate.models.Streaming_history;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    boolean existsByTitle(String title);

    List<Film> findByUserId(Integer userId);

    List<Film> findBySet_at(Country country);

    List<Film> findByNotation(Notation notation);

    List<Film> findByPlatforms(Streaming_history platform);
}
