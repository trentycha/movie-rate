package com.example.movie_rate.DTO;

public class CountryDTO {

    private Integer id;
    private String name;

    public CountryDTO(){}

    public CountryDTO(Integer id, String name) {
        this.id = id; this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
