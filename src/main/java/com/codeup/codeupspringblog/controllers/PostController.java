package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.model.Posts;
import com.codeup.codeupspringblog.model.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.TagRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

   private final EmailService emailService;
   private PostRepository postsDao;
   private UserRepository userDao;
   private TagRepository tagsDao;

    public PostController(PostRepository postsDao, UserRepository userDao, TagRepository tagsDao, EmailService emailService) {
        this.userDao = userDao;
        this.postsDao = postsDao;
        this.tagsDao = tagsDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String returnPosts(Model model){
        model.addAttribute("all", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/jpa/1")
    @ResponseBody
    public List<Posts> getAllPosts(){
        return postsDao.findAll();
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model){
        Optional<Posts> optionalPost = postsDao.findById(id);
        if (optionalPost.isPresent()){
            Posts posts = postsDao.findById(id).get();
            User user = posts.getUser();
            String email = user.getEmail();
            model.addAttribute("email",email);
            model.addAttribute("post", posts);
            return "posts/show";
        }else {
            return "redirect:/posts";
        }
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model){
        User newUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int CurrentUserId = newUser.getId();


        Posts editPost = postsDao.findById(id).get();
        if (CurrentUserId == editPost.getUser().getId()){
            model.addAttribute("editPost",editPost);
            Posts posts = postsDao.findById(id).get();
            User user = posts.getUser();
            String email = user.getEmail();
            model.addAttribute("email",email);
            model.addAttribute("post", posts);
            return "posts/edit";
        }else {
            return "redirect:/posts";
        }
    }

    @PostMapping("/posts/{id}/edit")
    public String changePost(@ModelAttribute Posts posts, @PathVariable long id){
        //Get it post
        Posts edit = postsDao.findById(id).get();
        //Set the new values into the posts
        edit.setTitle(posts.getTitle());
        //Set the new values into the posts
        edit.setBody(posts.getBody());
        postsDao.save(edit);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String createPostForm(Model model){
        model.addAttribute("newPost",new Posts());
        return "/posts/create";
    }




@PostMapping("/posts/create")
public String createPost(@ModelAttribute Posts newPost){
    User newUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    int id = newUser.getId();
    User user1 = userDao.findById(id);
    Posts post = new Posts(newPost.getTitle(), newPost.getBody(), user1);
    String subject = "Your post has been created";
    String body = "Your post has been created: " + post.getTitle();
    emailService.prepareAndSend(post, subject, body);
    postsDao.save(post);
    return "redirect:/posts";
}
@PostMapping("/delete/{id}")
public String deletePost(@PathVariable long id) {
    postsDao.deleteById(id);
    return "redirect:/posts";
}

}
