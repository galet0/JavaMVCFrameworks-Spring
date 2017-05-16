package com.softuni.models.viewModels.sales;


public class SaleWithCarMakeAndCustomerView {

    private long id;

    private String carMake;

    private String customerName;

    public SaleWithCarMakeAndCustomerView() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
