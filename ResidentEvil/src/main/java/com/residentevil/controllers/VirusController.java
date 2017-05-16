package com.residentevil.controllers;

import com.residentevil.entities.Magnitude;
import com.residentevil.entities.Mutation;
import com.residentevil.models.bindingModels.VirusBindingModel;
import com.residentevil.service.CapitalService;
import com.residentevil.service.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VirusController {

    private final CapitalService capitalService;

    private final VirusService virusService;

    @Autowired
    public VirusController(CapitalService capitalService, VirusService virusService) {
        this.capitalService = capitalService;
        this.virusService = virusService;
    }

    @ModelAttribute(name = "mutations")
    public List<String> getMutations(){
        List<String> mutationList = new ArrayList<>();
        Mutation[] mutations = Mutation.values();
        for (Mutation mutation : mutations) {
            mutationList.add(mutation.toString());
        }
        return mutationList;
    }

    @ModelAttribute(name = "magnitudes")
    public List<String> getMagnitudes(){
        List<String> magnitudeList = new ArrayList<>();
        Magnitude[] magnitudes = Magnitude.values();
        for (Magnitude magnitude : magnitudes) {
            magnitudeList.add(magnitude.toString());
        }

        return magnitudeList;
    }

    @ModelAttribute(name = "capitalList")
    public List<String> getCapitals(){
        List<String> capitals = this.capitalService.getCapitals();
        return capitals;
    }

    @GetMapping("/viruses")
    public String getAddVirusPage(@ModelAttribute VirusBindingModel virusBindingModel){
        return "add-viruses";
    }

    @PostMapping("/viruses")
    public String addVirus(@Valid @ModelAttribute VirusBindingModel virusBindingModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-viruses";
        }

        this.virusService.create(virusBindingModel);
         return "redirect:/";
    }
}
