package com.lucasgteixeira.cottonagroscience.controller;

import com.lucasgteixeira.cottonagroscience.model.Farmer;
import com.lucasgteixeira.cottonagroscience.service.FarmerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    private final FarmerService farmerService;

    public LoginController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @GetMapping("/")
    public String login(){
        return "fazendeiro/login";
    }

    @PostMapping("/login")
    public String loginFarmer(Farmer farmer, ModelMap map){
        Farmer isFarmerPresent = farmerService.findFarmerByEmailAndId(farmer.getEmail(), farmer.getPassword());
        if(isFarmerPresent == null)
            return "fazendeiro/login";
        else{
            map.addAttribute("logedFarmer", farmerService.findFarmerByEmailAndId(farmer.getEmail(), farmer.getPassword()));
            return "/home";
        }
    }
}
