package com.softuni.service;


import com.softuni.models.viewModels.sales.SaleDetailsView;
import com.softuni.models.viewModels.sales.SaleView;
import com.softuni.models.viewModels.sales.SaleWithCarMakeAndCustomerView;

import java.util.List;

public interface SaleService {

    List<SaleWithCarMakeAndCustomerView> getAllSales();

    SaleDetailsView findById(long id);

    List<SaleView> getAll();

    List<SaleView> getAllWithDiscount();

    List<SaleView> getAllByDiscount(double discount);
}
