package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

//    @GetMapping("/hello")
//    @ResponseBody
//    public String sayHello(){
//        return "Hello Dude";
//    }

    @GetMapping("/hello/{first}/{last}")
    @ResponseBody
    public String greetName(@PathVariable String first,@PathVariable String last){
        return "Hello " + first + " " +last;
    }



    @GetMapping("/hello")
    @ResponseBody
    public String greetName(@RequestParam(defaultValue = "true") boolean uppercase){
        if(uppercase){
            return "HELLO";
        } else {
            return "Hello";
        }
    }



    @GetMapping("/justin")
    @ResponseBody
    public String sayHelloJustin(){
        return "<h1>Hello Randy</h1>";
    }






}
