package com.example.movie_rate.Mapper;
import com.example.movie_rate.models.Film;
import com.example.movie_rate.DTO.FilmDTO;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    public FilmDTO toFilmDto (Film film) {

        return new FilmDTO(
                film.getId(),
                film.getTitle(),
                film.getCreatedAt(),
                film.getUpdatedAt(),
                film.getDirector(),
                film.getMainActors(),
                film.getDuration(),
                film.getYear(),
                film.getComment(),
                film.getAnecdote()
        );

    }

}

