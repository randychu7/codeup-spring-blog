package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    // Define a Car class with make, model, and year properties
     class Car {
        String make;
        String model;
        int year;

        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        @Override
        public String toString() {
            return "Make: " + make + ", Model: " + model + ", Year: " + year;
        }
    }

    // Create some Car instances
    Car car1 = new Car("Toyota", "Camry", 2019);
    Car car2 = new Car("Honda", "Accord", 2020);
    Car car3 = new Car("Ford", "Mustang", 2021);

    // Create an ArrayList of Cars
    ArrayList<Car> cars = new ArrayList<>(List.of(
            car1,
            car2,
            car3));

    @GetMapping("/howdy")
        public String returnHello(Model model){
         model.addAttribute("name","Randy");
         model.addAttribute("cars", cars);
        return "hello";
        }
}
