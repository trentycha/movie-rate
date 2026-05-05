package com.example.movie_rate.DTO;

public class UserDTO {

    private Integer id;
    private String username;
    private String mail;

    public UserDTO(){}

    public UserDTO(Integer id, String username, String mail) {
        this.id = id;
        this.username = username;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}


