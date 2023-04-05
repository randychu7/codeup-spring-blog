package com.codeup.codeupspringblog.model;

import jakarta.persistence.*;

import java.util.Set;

public class Comments {
//    Comments Table:
//    Comment ID (primary key)
//    Post ID (foreign key to Posts table)
//    User ID (foreign key to Users table)
//    Content
//            Timestamp
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(unique = true)
    private int commentId;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT(4000)")
    private String body;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "posts_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;
}
