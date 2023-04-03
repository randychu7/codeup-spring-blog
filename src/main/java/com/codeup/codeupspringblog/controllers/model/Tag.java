package com.codeup.codeupspringblog.controllers.model;

import jakarta.persistence.*;

import java.util.Set;

    @Entity
    @Table(name="tags")
    public class Tag {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(nullable = false, length = 55)
        private String name;

        //Is Like a List But does not allow duplicates, One tag can have many tags
        @ManyToMany(mappedBy = "tags")
        private Set<Posts> tags;

        public Tag() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<Posts> getTags() {
            return tags;
        }

        public void setTags(Set<Posts> tags) {
            this.tags = tags;
        }

        public Tag(String name) {
            this.name = name;
        }


        public Tag(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Tag(Set<Posts> tags) {
            this.tags = tags;
        }
    }


