package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.controllers.model.Posts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String returnPosts(Model model){
        ArrayList<Posts> posts = new ArrayList<>(Arrays.asList(
                new Posts(1,"Codeup is lit","Code up is the best I swear to god its so good ill get a job soon they promised me!"),
                new Posts(2,"Codeup is okay","Still no job after 5 months..."),
                new Posts(3,"Codeup blows!","2 years still no job and im homeless!")
        ));
        model.addAttribute("all", posts);
        return "posts/index";
    }

    @GetMapping("/posts/show/{n}")
    public String showPost( Model model, @PathVariable int n){
        model.addAttribute("n",n);
        ArrayList<Posts> posts = new ArrayList<>(Arrays.asList(
                new Posts(1,"Codeup is lit","Code up is the best I swear to god its so good ill get a job soon they promised me!"),
                new Posts(2,"Codeup is okay","Still no job after 5 months..."),
                new Posts(3,"Codeup blows!","2 years still no job and im homeless!")
        ));
        model.addAttribute("post", posts);

        return "posts/show";
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
