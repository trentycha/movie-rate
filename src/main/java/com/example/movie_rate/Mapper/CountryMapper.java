package com.example.movie_rate.Mapper;
import com.example.movie_rate.DTO.CountryDTO;
import com.example.movie_rate.models.Country;

public class CountryMapper {

    public CountryDTO toUserDto (Country country) {

        return new CountryDTO(
                country.getId(),
                country.getName()
        );

    }

}
