package com.softuni.models.viewModels.customers;


import com.softuni.models.viewModels.sales.SaleView;

import java.util.Set;

public class CustomerDetailsView {

    private String name;

    private Set<SaleView> sales;

    private double totalSum;

    public CustomerDetailsView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SaleView> getSales() {
        return sales;
    }

    public void setSales(Set<SaleView> sales) {
        this.sales = sales;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }
}
