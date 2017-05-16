package com.softuni.controllers;

import com.softuni.models.bindingModels.cars.CarModel;
import com.softuni.models.bindingModels.cars.EditCarModel;
import com.softuni.models.bindingModels.parts.PartNameModel;
import com.softuni.models.viewModels.cars.CarViewModel;
import com.softuni.models.viewModels.cars.CarWithPartsView;
import com.softuni.models.viewModels.parts.PartDetailModel;
import com.softuni.service.CarService;
import com.softuni.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private PartService partService;

    @GetMapping("all")
    public String getCarsTablePage(Model model, @RequestParam(value = "make", required = false) String make){
        List<CarViewModel> carViewModels = this.carService.getAllByMake(make);
        model.addAttribute("cars", carViewModels);
        model.addAttribute("view", "/cars/cars-table");
        return "base-layout";
    }

    @GetMapping("{id}/parts")
    public String getCarPartsPage(Model model, @PathVariable long id){
        CarWithPartsView carWithPartsView = this.carService.getById(id);
        model.addAttribute("car", carWithPartsView);
        model.addAttribute("view", "/cars/car-parts-table");
        return "base-layout";
    }

    @GetMapping("add")
    public String getAddCarPage(Model model){
        CarModel carModel = new CarModel();
        Set<PartDetailModel> parts = this.partService.getAll();
        model.addAttribute("parts", parts);
        model.addAttribute("car", carModel);
        model.addAttribute("view", "/cars/add-car");
        return "base-layout";
    }

    @PostMapping("add")
    public String addCarPage(@ModelAttribute CarModel carModel, @RequestParam(required = false) String[] partsNames){
        Set<PartNameModel> partDetailModels = new HashSet<>();
        for (String partsName : partsNames) {
            PartNameModel partDetailModel = this.partService.getByName(partsName);
            partDetailModels.add(partDetailModel);
        }
        carModel.setParts(partDetailModels);
        this.carService.create(carModel);
        return "redirect:/cars/all";
    }

//    @GetMapping("edit/{id}")
//    public String getEditPartPage(Model model, @PathVariable long id){
//        EditCarModel modifiablePartModel = this.carService.getByIdToEdit(id);
//        model.addAttribute("car", modifiablePartModel);
//        model.addAttribute("type", "Edit");
//        model.addAttribute("view", "/cars/modifiable-car");
//        return "base-layout";
//    }
//
//    @PostMapping("edit/{id}")
//    public String editPart(@ModelAttribute EditCarModel editCar, @PathVariable long id){
//        String make = editCar.getMake();
//        String model = editCar.getModel();
//        double travelledDistance = editCar.getTravelledDistance();
//        this.carService.updateCar(make, model, travelledDistance, id);
//        return "redirect:/cars/all";
//    }


}
