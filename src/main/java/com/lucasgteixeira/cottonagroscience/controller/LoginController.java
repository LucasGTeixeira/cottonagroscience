package com.lucasgteixeira.cottonagroscience.controller;

import com.lucasgteixeira.cottonagroscience.model.Farmer;
import com.lucasgteixeira.cottonagroscience.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final FarmerService farmerService;

    @Autowired
    public LoginController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @GetMapping("/")
    public String login(){
        return "/fazendeiros/login";
    }

    @PostMapping("/loginValidation")
    public String loginValidation(Model model, Farmer adparam){
        Farmer farmer = this.farmerService.loginAuthentification(adparam.getEmail(), adparam.getPassword());
        if(farmer != null)
            return "redirect:/home";
        model.addAttribute("Error", "User or password not valid");
        return "redirect:/";
    }
}
