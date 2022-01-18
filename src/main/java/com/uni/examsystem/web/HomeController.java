package com.uni.examsystem.web;

import com.uni.examsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String login() {
        return "redirect:/users/login";
    }

    @GetMapping("/index")
    public String index(){return "index";}
}
