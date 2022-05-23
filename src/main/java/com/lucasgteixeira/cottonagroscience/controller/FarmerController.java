package com.lucasgteixeira.cottonagroscience.controller;

import com.lucasgteixeira.cottonagroscience.model.Farmer;
import com.lucasgteixeira.cottonagroscience.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/farmers")
public class FarmerController {

    private final FarmerService farmerService;

    @Autowired
    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @GetMapping("/add")
    public String addFarmer(Farmer farmer){
        return "/fazendeiros/cadastro";
    }

    @PostMapping("/save")
    public String save(Farmer farmer, RedirectAttributes attr){
        farmerService.addNewFarmer(farmer);
        attr.addFlashAttribute("success","fazendeiro inserido com sucesso.");
        return "redirect:/farmers/add";
    }

    @GetMapping("/update/{id}")
    public String preUpdate(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("farmer",farmerService.getFarmerById(id));
        return "fazendeiros/cadastro";
    }

    @PostMapping("/update")
    public String update(Farmer farmer, RedirectAttributes attr){
        farmerService.updateFarmer(farmer);
        attr.addFlashAttribute("success","fazendeiro editado com sucesso.");
        return "redirect:/farmers/add";
    }

    @GetMapping("/listAll")
    public String listFarmers(ModelMap map){
        map.addAttribute("farmers",farmerService.getFarmers());
        return "fazendeiros/lista";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,ModelMap model){
        farmerService.deleteFarmer(id);
        model.addAttribute("success","fazendeiro excluído com sucesso!!");
        return listFarmers(model);
    }
}
