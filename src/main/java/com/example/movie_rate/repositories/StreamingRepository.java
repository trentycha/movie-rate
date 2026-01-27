package com.example.movie_rate.repositories;

import com.example.movie_rate.models.Streaming_history;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming_history, Integer> {

}
