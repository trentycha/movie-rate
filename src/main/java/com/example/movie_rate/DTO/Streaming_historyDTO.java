package com.example.movie_rate.DTO;

import java.time.LocalDate;

public class Streaming_historyDTO {

    private Integer id;
    private String platform;
    private Boolean hasFilm;
    private LocalDate updated_at;

    public Streaming_historyDTO(){}

    public Streaming_historyDTO(Integer id, String platform, Boolean hasFilm, LocalDate updated_at) {
        this.id = id;
        this.platform = platform;
        this.hasFilm = hasFilm;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform() {
        this.platform = platform;
    }

    public Boolean getHasFilm() {
        return hasFilm;
    }

    public void setHasFilm() {
        this.hasFilm = hasFilm;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at() {
        this.updated_at = updated_at;
    }

}
