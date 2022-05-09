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


    @GetMapping("/cadastrar")
    public String cadastrar(Farmer farmer){
        return "/fazendeiro/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Farmer farmer, RedirectAttributes attr){
        farmerService.addNewFarmer(farmer);
        attr.addFlashAttribute("success","fazendeiro inserido com sucesso.");
        return "redirect:/farmers/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("farmer",farmerService.getFarmerById(id));
        return "/fazendeiro/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Farmer farmer, RedirectAttributes attr){
        farmerService.updateFarmer(farmer);
        attr.addFlashAttribute("success","fazendeiro editado com sucesso.");
        return "redirect:/farmers/cadastrar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map){
        map.addAttribute("farmers",farmerService.getFarmers());
        return "/fazendeiro/lista";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id,ModelMap model){
        farmerService.deleteFarmer(id);
        model.addAttribute("success","fazendeiro excluído com sucesso!!");
        return listar(model);
    }
}
