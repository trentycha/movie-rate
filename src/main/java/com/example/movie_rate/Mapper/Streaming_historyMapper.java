package com.example.movie_rate.Mapper;
import com.example.movie_rate.DTO.Streaming_historyDTO;
import com.example.movie_rate.models.Streaming_history;

public class Streaming_historyMapper {

    public Streaming_historyDTO toUserDto (Streaming_history streaming_history) {

        return new Streaming_historyDTO(
                streaming_history.getId(),
                streaming_history.getPlatform(),
                streaming_history.getHasFilm(),
                streaming_history.getUpdated_at()
        );

    }

}
