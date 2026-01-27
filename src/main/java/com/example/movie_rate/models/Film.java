package com.example.movie_rate.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = true)
    private LocalDate created_at;

    @Column(nullable = true)
    private LocalDate updated_at;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "note_id", referencedColumnName = "id")
    private Notation notation;

    @ManyToMany
    @JoinTable(
            name = "set_at",
            joinColumns = @JoinColumn(name = "film"),
            inverseJoinColumns = @JoinColumn(name = "country")
    )
    private Set<Country> set_at = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "stream_available",
            joinColumns = @JoinColumn(name = "film"),
            inverseJoinColumns = @JoinColumn(name = "streaming_history")
    )
    private Set<Streaming_history> platforms = new HashSet<>();


    public Film(){}

    public Film(String title, LocalDate created_at, LocalDate updated_at, String director, String mainActors, Integer duration, Integer year, String comment, String anecdote) {
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

    public User getUser() {
        return user;
    }

    public User setUser(User user) {
        return this.user = user;
    }

    public Notation getNotation() {
        return notation;
    }

    public Notation setNotation(Notation notation) {
        return this.notation = notation;
    }

    public Set<Country> getSet_at() {
        return this.set_at;
    }

    public void setSet_at(Set<Country> set_at) {
        this.set_at = set_at;
    }

    public Set<Streaming_history> getPlatforms() {
        return this.platforms;
    }

    public void setPlatforms(Set<Streaming_history> platforms) {
        this.platforms = platforms;
    }

}
