package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.Product;
import com.codeup.codeupspringblog.repositories.ProductsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private ProductsRepository productsDao;

    public ProductController(ProductsRepository productsDao){
        this.productsDao = productsDao;
    }

    @GetMapping("/products/create")
    public String products(){
        return "product/createProduct";
    }

    @PostMapping("/products/create")
    public String insertProduct(@RequestParam String product, @RequestParam int price){
        System.out.println(price);
        return "redirect:/";
    }





    @GetMapping("/product")
    public String getProductView(Model model){
        List<Product> products = productsDao.findAll();
        model.addAttribute("products", products);
        return "product/index";
    }




}

