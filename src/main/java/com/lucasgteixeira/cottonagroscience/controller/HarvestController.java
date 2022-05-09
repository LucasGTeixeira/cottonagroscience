package com.lucasgteixeira.cottonagroscience.controller;

import com.lucasgteixeira.cottonagroscience.model.Harvest;
import com.lucasgteixeira.cottonagroscience.model.Harvest;
import com.lucasgteixeira.cottonagroscience.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/harvests")
public class HarvestController {

    private final HarvestService harvestService;

    @Autowired
    public HarvestController(HarvestService harvestService) {
        this.harvestService = harvestService;
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Harvest harvest){
        return "/safras/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(Harvest harvest, RedirectAttributes attr){
        harvestService.addNewHarvest(harvest);
        attr.addFlashAttribute("success","safra inserida com sucesso.");
        return "redirect:/harvests/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("harvest",harvestService.getHarvestById(id));
        return "/safras/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Harvest harvest, RedirectAttributes attr){
        harvestService.updateHarvest(harvest);
        attr.addFlashAttribute("success","safra editada com sucesso.");
        return "redirect:/harvests/cadastrar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map){
        map.addAttribute("harvests",harvestService.getHarvests());
        return "/safras/lista";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id,ModelMap model){
        harvestService.deleteHarvest(id);
        model.addAttribute("success","safra excluída com sucesso!!");
        return listar(model);
    }
}
