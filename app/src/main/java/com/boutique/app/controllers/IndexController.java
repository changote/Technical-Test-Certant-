package com.boutique.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("title","Bienvenido a la Boutique Certant ");
        return "index";
    }
}
