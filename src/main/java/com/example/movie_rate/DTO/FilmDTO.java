package com.example.movie_rate.DTO;

import java.time.LocalDate;

public class FilmDTO {

    private Integer id;
    private String title;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String director;
    private String mainActors;
    private Integer duration;
    private Integer year;
    private String comment;
    private String anecdote;

    public FilmDTO(){}

    public FilmDTO(Integer id, String title, LocalDate created_at, LocalDate updated_at, String director, String mainActors, Integer duration, Integer year, String comment, String anecdote) {
        this.id = id;
        this.title = title;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.director = director;
        this.duration = duration;
        this.year = year;
        this.comment = comment;
        this.anecdote = anecdote;
        this.mainActors = mainActors;
    }

    public Integer getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public LocalDate getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public String getDirector() {

        return director;
    }

    public void setDirector(String director) {

        this.director = director;
    }

    public String getMainActors() {

        return mainActors;
    }

    public void setMainActors(String mainActors) {

        this.mainActors = mainActors;
    }

    public Integer getDuration() {

        return duration;
    }

    public void setDuration(Integer duration) {

        this.duration = duration;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAnecdote() {
        return anecdote;
    }

    public void setAnecdote(String anecdote) {
        this.anecdote = anecdote;
    }

}
