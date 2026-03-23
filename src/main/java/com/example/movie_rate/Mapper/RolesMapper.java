package com.example.movie_rate.Mapper;
import com.example.movie_rate.DTO.RolesDTO;
import com.example.movie_rate.models.Roles;

public class RolesMapper {

    public RolesDTO toUserDto (Roles roles) {

        return new RolesDTO(
                roles.getId(),
                roles.getLabel()
        );

    }

}
