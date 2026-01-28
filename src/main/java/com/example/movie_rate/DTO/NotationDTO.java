package com.example.movie_rate.DTO;

public class NotationDTO {

    private Integer id;
    private Float note;

    public NotationDTO(){}

    public NotationDTO(Integer id, Float note) {
        this.id = id; this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

}
