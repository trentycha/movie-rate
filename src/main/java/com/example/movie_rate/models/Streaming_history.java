package com.example.movie_rate.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "streaming_history")
public class Streaming_history {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String platform;

    @Column(nullable = false)
    private Boolean hasFilm;

    @Column(nullable = false)
    private LocalDate updated_at;

    @ManyToMany(mappedBy = "platforms")
    private Set<Film> films = new HashSet<>();


    public Streaming_history(){}

    public Streaming_history(String platform, Boolean hasFilm, LocalDate updated_at) {
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

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

}
