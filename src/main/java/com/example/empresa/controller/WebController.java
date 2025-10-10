package com.example.empresa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        // procura um arquivo chamado "index.html" na pasta resources/templates
        return "index";
    }
}

