package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String returnPosts(){
        return "This shows all the posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showPost(@PathVariable long id){
        return "This shows the post for " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm(){
        return "View Create a post";
    }

    @PostMapping("/posts/create")
    public String createPost(){
        return "created post";
    }






}
