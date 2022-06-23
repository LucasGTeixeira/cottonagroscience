package com.lucasgteixeira.cottonagroscience.controller;

import com.lucasgteixeira.cottonagroscience.model.Farmer;
import com.lucasgteixeira.cottonagroscience.model.Harvest;
import com.lucasgteixeira.cottonagroscience.model.Harvest;
import com.lucasgteixeira.cottonagroscience.service.FarmerService;
import com.lucasgteixeira.cottonagroscience.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;


@Controller
@RequestMapping("/harvests")
public class HarvestController {

    private final HarvestService harvestService;
    private final FarmerService farmerService;

    @Autowired
    public HarvestController(HarvestService harvestService, FarmerService farmerService) {
        this.harvestService = harvestService;
        this.farmerService = farmerService;
    }

    @GetMapping("/add")
    public String addNewHarvest(Harvest harvest, ModelMap map){
        List<Farmer> farmerList = farmerService.getFarmers();
        map.addAttribute("farmers", farmerList);
        return "/safras/cadastro";
    }

    @PostMapping("/save")
    public String salvar(Harvest harvest, RedirectAttributes attr){
        harvestService.addNewHarvest(harvest);
        attr.addFlashAttribute("success","safra inserida com sucesso.");
        return "redirect:/harvests/add";
    }

    @GetMapping("/update/{id}")
    public String preUpdate(@PathVariable("id") Long id, ModelMap model){
        List<Farmer> farmerList = farmerService.getFarmers();
        model.addAttribute("farmers", farmerList);
        model.addAttribute("harvest",harvestService.getHarvestById(id));
        return "/safras/cadastro";
    }

    @PostMapping("/update")
    public String update(Harvest harvest, RedirectAttributes attr){
        harvestService.updateHarvest(harvest);
        attr.addFlashAttribute("success","safra editada com sucesso.");
        return "redirect:/harvests/add";
    }

    @GetMapping("/listAll")
    public String listAllHarvests(ModelMap map){
        map.addAttribute("harvests",harvestService.getHarvests());
        return "/safras/lista";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,ModelMap model){
        harvestService.deleteHarvest(id);
        model.addAttribute("success","safra excluída com sucesso!!");
        return listAllHarvests(model);
    }

    @GetMapping("/filter")
    public String listFilterHarvests(ModelMap map){
        map.addAttribute("harvests", harvestService.getHarvests());
        return "/safras/filtros.html";
    }

    @GetMapping("filter/destination")
    public String getHarvestsByDestination(@RequestParam("destination") String destination, ModelMap map){
        map.addAttribute("harvests", harvestService.getHarvestsByDestination(destination));
        return "/safras/filtros";
    }

    @GetMapping("filter/profitMargin")
    public String getHarvestsByProfitMargin(@RequestParam("profitMargin")BigDecimal profitMargin, ModelMap map){
        map.addAttribute("harvests", harvestService.getHarvestsByProfitMargin(profitMargin));
        return "safras/filtros";
    }

}