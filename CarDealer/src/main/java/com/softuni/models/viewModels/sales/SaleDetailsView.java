package com.softuni.models.viewModels.sales;

public class SaleDetailsView {

    private long id;

    private String carMake;

    private String carModel;

    private String customerName;

    private double saleDiscount;

    public SaleDetailsView() {
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

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getSaleDiscount() {
        return saleDiscount;
    }

    public void setSaleDiscount(double saleDiscount) {
        this.saleDiscount = saleDiscount;
    }
}
