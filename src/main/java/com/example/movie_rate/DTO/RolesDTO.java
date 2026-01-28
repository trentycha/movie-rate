package com.example.movie_rate.DTO;

public class RolesDTO {

    private Integer id;
    private String label;

    public RolesDTO(){}

    public RolesDTO(Integer id, String label) {
        this.id = id; this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
