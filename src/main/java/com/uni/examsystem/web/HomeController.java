package com.uni.examsystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/index-admin")
    public  String indexAdmin(){return "index-admin";}
}
