package com.softuni.controllers;

import com.softuni.models.bindingModels.parts.PartModel;
import com.softuni.models.bindingModels.parts.EditPartModel;
import com.softuni.models.viewModels.parts.PartDetailModel;
import com.softuni.models.viewModels.parts.PartViewModel;
import com.softuni.models.viewModels.suppliers.SupplierNameView;
import com.softuni.service.PartService;
import com.softuni.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("parts")
public class PartController {

    @Autowired
    private PartService partService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("all")
    public String getAllPartsPage(Model model){
        Set<PartViewModel> partViewModelList = this.partService.getAllParts();
        model.addAttribute("parts", partViewModelList);
        model.addAttribute("view", "/parts/parts-table");
        return "base-layout";
    }

    @GetMapping("{id}")
    public String getPartDetailsPage(Model model, @PathVariable long id){
        PartDetailModel partDetailModel = this.partService.getPartById(id);
        model.addAttribute("part", partDetailModel);
        model.addAttribute("view", "/parts/part-details");
        return "base-layout";
    }

    @GetMapping("add")
    public String getAddPartPage(Model model){
        PartModel modifiablePartModel = new PartModel();
        List<SupplierNameView> supplierNameViews = this.supplierService.getAll();
        model.addAttribute("suppliers", supplierNameViews);
        model.addAttribute("part", modifiablePartModel);
        model.addAttribute("type", "Add");
        model.addAttribute("view", "/parts/add-parts");
        return "base-layout";
    }

    @PostMapping("add")
    public String addPart(@ModelAttribute PartModel modifiablePartModel, @RequestParam String supplierName){
        SupplierNameView supplierNameView = this.supplierService.getByName(supplierName);
        modifiablePartModel.setSupplier(supplierNameView);
        modifiablePartModel.setQuantity(modifiablePartModel.getQuantity() == 0L ? 1L : modifiablePartModel.getQuantity());
        this.partService.create(modifiablePartModel);
        return "redirect:/parts/all";
    }

    @GetMapping("edit/{id}")
    public String getEditPartPage(Model model, @PathVariable long id){
        PartModel modifiablePartModel = this.partService.getByIdToEdit(id);
        model.addAttribute("part", modifiablePartModel);
        model.addAttribute("type", "Edit");
        model.addAttribute("view", "/parts/edit-parts");
        return "base-layout";
    }

    @PostMapping("edit/{id}")
    public String editPart(@ModelAttribute EditPartModel editPartModel, @PathVariable long id){
        double price = editPartModel.getPrice();
        long quantity = editPartModel.getQuantity();
        this.partService.updatePart(price, quantity, id);
        return "redirect:/parts/all";
    }

    @GetMapping("delete/{id}")
    public String getDeletePartPage(Model model, @PathVariable long id){
        PartModel partModel = this.partService.getByIdToEdit(id);
        model.addAttribute("part", partModel);
        model.addAttribute("view", "/parts/delete-part");
        return "base-layout";
    }

    @PostMapping("delete/{id}")
    public String deletePart(@ModelAttribute PartModel partModel, @PathVariable long id){
        partModel.setId(id);
        this.partService.delete(partModel);
        return "redirect:/parts/all";
    }
}
