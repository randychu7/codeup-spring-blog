package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class RollDice {
    @GetMapping("/roll-dice")
    public String rollDice(){
        return "rollDice";
    }



    @GetMapping("/roll-dice/{guess}")
    public String rollDiceForm(@PathVariable int guess, Model model) {
        int roll = (int) (Math.random() * 6) + 1;
        model.addAttribute("guess", guess);
        model.addAttribute("roll", roll);
        model.addAttribute("message", guess == roll ? "That is correct" : "That is wrong");
        return "rollDice";
    }


}

