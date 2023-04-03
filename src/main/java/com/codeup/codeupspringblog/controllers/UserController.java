package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.controllers.model.Posts;
import com.codeup.codeupspringblog.controllers.model.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository usersDao;
    private final PostRepository postDao;


    public UserController(UserRepository usersDao, PostRepository postDao){
        this.usersDao = usersDao;
        this.postDao = postDao;
    }

    @GetMapping("/register")
    public String registerPage(){
        return "/posts/register";
    }


    @PostMapping("/register")
    public String registerUser(@RequestParam(name="username") String username, @RequestParam(name="email") String email, @RequestParam(name="password") String password){
        User user = new User(username, email, password);
        usersDao.save(user);
        return "redirect:/posts";
    }

    @GetMapping("/user/{id}/posts")
    public String usersAds(@PathVariable long id, Model model){
        User user = usersDao.findById(id);
        List<Posts> userPost = user.getPosts();
        model.addAttribute("userAds", userPost);
        return "/posts/userPost";
    }

}
