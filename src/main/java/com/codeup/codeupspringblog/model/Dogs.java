package com.codeup.codeupspringblog.model;

//When running the ‘SHOW CREATE TABLE dogs’, you should have the following schema:
//        CREATE TABLE `dogs` (
//        `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
//        `age` tinyint(3) unsigned NOT NULL,
//        `name` varchar(200) NOT NULL,
//        `reside_state` char(2) DEFAULT ‘XX’,
//        PRIMARY KEY (`id`),
//        UNIQUE KEY `UK_?????????????????` (`age`)
//        ) ENGINE=MyISAM DEFAULT CHARSET=utf8

import jakarta.persistence.*;

@Entity
@Table(name = "dogs")
public class Dogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = true, unique = true)
    private int id;

    @Column (nullable = false, length = 3)
    private int age;

    @Column (nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 2)
    private String reside_state;

    public Dogs(int id, int age, String name, String reside_state) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.reside_state = reside_state;
    }

    public Dogs(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReside_state(String reside_state) {
        this.reside_state = reside_state;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getReside_state() {
        return reside_state;
    }
}

