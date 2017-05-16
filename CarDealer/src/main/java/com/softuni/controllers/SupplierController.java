package com.softuni.controllers;

import com.softuni.models.viewModels.suppliers.SupplierViewModel;
import com.softuni.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers")
    public String getSupplierPage(Model model, @RequestParam(value = "filter", required = false) String filter){
        Set<SupplierViewModel> supplierViewModels = this.supplierService.getAllSuppliers(filter);
        model.addAttribute("suppliers", supplierViewModels);
        model.addAttribute("view", "/suppliers/suppliers-table");
        return "base-layout";
    }
}
