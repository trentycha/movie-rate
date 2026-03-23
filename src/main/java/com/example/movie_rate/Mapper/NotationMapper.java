package com.example.movie_rate.Mapper;
import com.example.movie_rate.DTO.NotationDTO;
import com.example.movie_rate.models.Notation;

public class NotationMapper {

    public NotationDTO toUserDto (Notation notation) {

        return new NotationDTO(
                notation.getId(),
                notation.getNote()
        );

    }

}
