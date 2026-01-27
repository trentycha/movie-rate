package com.example.movie_rate.models;

import jakarta.persistence.*;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = true)
    private String director;

    @Column(nullable = true)
    private String mainActors;

    @Column(nullable = true)
    private Integer duration;

    @Column(nullable = true)
    private Integer year;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String comment;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String anecdote;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Film(){}

    public Film(String title, String director, String mainActors, Integer duration, Integer year, String comment, String anecdote) {
        this.title = title;
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

    public User getUser() {
        return user;
    }

    public User setUser(User user) {
        return this.user = user;
    }

}
