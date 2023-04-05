package com.codeup.codeupspringblog.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    @Column(columnDefinition = "VARCHAR(100)")
    private String username;

    @Column(columnDefinition = "VARCHAR(50)")
    private String email;


    private String password;


    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Posts> posts;
//
//    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
//    private List<Comments> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //User Constructor
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
    }

    public User(){

    }

//    public static void main(String[] args) {
//        User user1 = new User(1,"randy123", "1234","1234");
//        User user2 = new User(user1);
//    }



}
