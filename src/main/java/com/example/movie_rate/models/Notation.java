package com.example.movie_rate.models;

import jakarta.persistence.*;

@Entity
@Table(name = "notation")
public class Notation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private Float note;

    public Notation(){}

    public Notation(Float note) {
        this.note = note;
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
