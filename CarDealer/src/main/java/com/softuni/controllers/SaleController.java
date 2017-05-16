package com.softuni.controllers;

import com.softuni.models.viewModels.sales.SaleDetailsView;
import com.softuni.models.viewModels.sales.SaleView;
import com.softuni.models.viewModels.sales.SaleWithCarMakeAndCustomerView;
import com.softuni.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("all")
    public String getSalesPage(Model model){
        List<SaleWithCarMakeAndCustomerView> saleView = this.saleService.getAllSales();
        model.addAttribute("sales", saleView);
        model.addAttribute("view", "/sales/sales-table");
        return "base-layout";
    }

    @GetMapping("{id}")
    public String getSaleDetailsPage(Model model, @PathVariable long id){
        SaleDetailsView saleDetailsView = this.saleService.findById(id);
        model.addAttribute("sale", saleDetailsView);
        model.addAttribute("view", "/sales/sale-details");
        return "base-layout";
    }

    @GetMapping("discounted")
    public String getDiscountPage(Model model){
        List<SaleView> saleViews = this.saleService.getAllWithDiscount();
        model.addAttribute("sales", saleViews);
        model.addAttribute("view", "/sales/sales-table");
        return "base-layout";
    }

    @GetMapping("discounted/{percent:\\d*\\.?\\d*}")
    public String getDiscountWithPercentPage(Model model, @PathVariable double percent){
        List<SaleView> saleViews = this.saleService.getAllByDiscount(percent);
        model.addAttribute("sales", saleViews);
        model.addAttribute("view", "/sales/sales-table");
        return "base-layout";
    }

//    private List<SaleView> getSales(String discount){
//        List<SaleView>saleViews = new ArrayList<>();
//        Pattern pattern = Pattern.compile("\\d\\.\\d{1,2}");
//        Matcher matcher = pattern.matcher(discount == null ? "" : discount);
//        if(matcher.find()){
//            double percent = Double.parseDouble(discount);
//            saleViews = this.saleService.getAllByDiscount(percent);
//        } else {
//            saleViews = this.saleService.getAll();
//        }
//
//        return saleViews;
//    }
}
