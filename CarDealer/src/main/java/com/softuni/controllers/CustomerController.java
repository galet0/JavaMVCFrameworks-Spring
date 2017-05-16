package com.softuni.controllers;

import com.softuni.models.bindingModels.customers.AddCustomerModel;
import com.softuni.models.bindingModels.customers.EditCustomerModel;
import com.softuni.models.viewModels.customers.CustomerDetailsView;
import com.softuni.models.viewModels.customers.CustomerViewModel;
import com.softuni.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("all")
    public String getCustomerPage(Model model, @RequestParam(value = "filter", required = false) String filter){
        Set<CustomerViewModel> customerViewModels = this.customerService.getAllOrderedByBirthDate(filter);
        model.addAttribute("customers", customerViewModels);
        model.addAttribute("view", "/customers/customers-table");
        return "base-layout";
    }

    @GetMapping("{id}")
    public String getCustomerDetailsPage(Model model, @PathVariable long id){
        CustomerDetailsView customerDetailsView = this.customerService.getById(id);
        model.addAttribute("customer", customerDetailsView);
        model.addAttribute("view", "/customers/customer-details");
        return "base-layout";
    }

    @GetMapping("add")
    public String getAddCustomerPage(Model model){
        AddCustomerModel addCustomerModel = new AddCustomerModel();
        model.addAttribute("customer", addCustomerModel);
        model.addAttribute("view", "/customers/add-customer");
        return "base-layout";
    }

    @PostMapping("add")
    public String addCustomer(@ModelAttribute AddCustomerModel addCustomerModel){
        addCustomerModel.setYoungDriver(this.isYoungDriver(addCustomerModel.getBirthDate()));
        this.customerService.create(addCustomerModel);
        return "redirect:/customers/all";
    }

    @GetMapping("edit/{id}")
    public String getEditCustomerPage(Model model, @PathVariable long id){
        EditCustomerModel editCustomerModel = this.customerService.getByIdToEdit(id);
        model.addAttribute("customer", editCustomerModel);
        model.addAttribute("type", "Edit");
        model.addAttribute("view", "/customers/modifiable-customer");
        return "base-layout";
    }

//    @PostMapping("edit/{id}")
//    public String editCustomer(@ModelAttribute EditCustomerModel editCustomerModel, @PathVariable long id){
//        editCustomerModel.setIsYoungDriver(this.isYoungDriver(editCustomerModel.getBirthDate()));
//        editCustomerModel.setId(id);
//
//    }

    @PostMapping("edit/{id}")
    public String editCustomer(@ModelAttribute EditCustomerModel editCustomerModel, @PathVariable long id){
        String name = editCustomerModel.getName();
        Date birthDate = editCustomerModel.getBirthDate();
        this.customerService.updateCustomer(name, birthDate, id);
        return "redirect:/customers/all";
    }

    private boolean isYoungDriver(Date birthDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        LocalDate localDate =LocalDate.of(year, month, date);
        LocalDate now = LocalDate.now();
        Period diff =Period.between(localDate, now);
        return diff.getYears() < 20;
    }
}
