package ru.itis.deshevin.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/homepage")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/")
    public String redirectHomePage() {
        return "redirect:/homepage";
    }

}