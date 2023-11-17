package net.rabbitmq.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/test")
    String main(String name, Model model) {
        System.out.println(name);
        model.addAttribute("name", name);
        return "main";
    }
}
