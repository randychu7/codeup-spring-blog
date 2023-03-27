package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @GetMapping("/products/create")
    public String products(Model model){
        return "product";
    }

    @PostMapping("/products/create")
    public String insertProduct(@RequestParam String product, @RequestParam int price){
        System.out.println(price);
        return "redirect:/";
    }


}

