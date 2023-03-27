package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.controllers.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    @GetMapping("/products/create")
    public String products(Model model){
        return "product/createProduct";
    }

    @PostMapping("/products/create")
    public String insertProduct(@RequestParam String product, @RequestParam int price){
        System.out.println(price);
        return "redirect:/";
    }

    @GetMapping("/product")
    public String getProductView(Model model){
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(1,"Xbox",10000),
                new Product(2,"PS5",20000),
                new Product(3,"CDI",50000)
        ));
        model.addAttribute("products", products);
        return "product/index";
    }


}

