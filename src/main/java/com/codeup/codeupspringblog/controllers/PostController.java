package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.controllers.model.Posts;
import com.codeup.codeupspringblog.controllers.model.Tag;
import com.codeup.codeupspringblog.controllers.model.Tags;
import com.codeup.codeupspringblog.controllers.model.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.TagRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        Optional<Posts> editPost = postsDao.findById(id);

        if (editPost.isPresent()){
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
        User users = userDao.findById(1);
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

//    @PostMapping("/posts/create")
//    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, @RequestParam(name = "tags") String tags){
//        User users = userDao.findById(1);
//        Set<Tag> tagSet = Tags.makeTagSet(tags);
//        Posts newPost = new Posts(title,body, users);
//        if(tagSet.size() > 0 ){
//            List<Tag> tagsToAdd = new ArrayList<>();
//            for (Tag tag : tagSet){
//                Tag tagFromDb = tagsDao.findTagByName(tag.getName());
//                if (tagFromDb == null){
//                    tagsToAdd.add(tagsDao.save(tag));
//                } else {
//                    tagsToAdd.add(tagFromDb);
//                }
//            }
//            tagSet.clear();
//            tagSet.addAll(tagsToAdd);
//            newPost.setTags(tagSet);
//        }
//        postsDao.save(newPost);
//        return "redirect:/posts";
//    }


@PostMapping("/posts/create")
public String createPost(@ModelAttribute Posts newPost){
    User users = userDao.findById(1);
    Posts post = new Posts(newPost.getTitle(), newPost.getBody(),users);
    String subject = "Your post has been created";
    String body = "Your post has been created: " + post.getTitle();
    emailService.prepareAndSend(post, subject, body);
    postsDao.save(post);
    return "redirect:/posts";
}

//@GetMapping("/")
//    public String welcome(){
//        emailService.prepareAndSend("text","this is test");
//    System.out.println("Email Sent");
//    return "posts/index";
//}

}
