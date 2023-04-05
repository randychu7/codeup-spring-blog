package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.model.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
    public class UserController {
        private UserRepository userDao;
        private PasswordEncoder passwordEncoder;

        public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
            this.userDao = userDao;
            this.passwordEncoder = passwordEncoder;
        }

        @GetMapping("/register")
        public String showSignupForm(Model model){
            model.addAttribute("user", new User());
            return "users/register";
        }

    @PostMapping("/register")
        public String saveUser(@ModelAttribute User user){
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
            System.out.println(user);
            userDao.save(user);
            return "redirect:/login";
        }



    }


//    private final UserRepository usersDao;
//    private final PostRepository postDao;
//    private final PasswordEncoder passwordEncoder;
//
//
//    public UserController(UserRepository usersDao, PostRepository postDao, PasswordEncoder passwordEncoder){
//        this.usersDao = usersDao;
//        this.postDao = postDao;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//
//@GetMapping("/login")
//public String login(){
//        return "/posts/login";
//}



//    @PostMapping("/register")
//    public String registerUser(@RequestParam(name="username") String username, @RequestParam(name="email") String email, @RequestParam(name="password") String password){
//        User user = new User(username, email, password);
//        usersDao.save(user);
//        return "redirect:/posts";
//    }
//    @GetMapping("/register")
//    public String registerPage(){
//        return "/posts/register";
//    }
//
//    @PostMapping("/register")
//    public String saveUser(@ModelAttribute User user){
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        usersDao.save(user);
//        return "redirect:/posts";
//    }
//
//    @GetMapping("/user/{id}/posts")
//    public String usersAds(@PathVariable long id, Model model){
//        User user = usersDao.findById(id);
//        List<Posts> userPost = user.getPosts();
//        model.addAttribute("userAds", userPost);
//        return "/posts/userPost";
//    }


