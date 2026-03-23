package com.example.movie_rate.Mapper;
import com.example.movie_rate.models.User;
import com.example.movie_rate.DTO.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class userMapper {

    public UserDTO toUserDto (User user) {

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getMail()
        );

    }

}
