package com.softuni.models.bindingModels.parts;

import com.softuni.models.viewModels.suppliers.SupplierNameView;

public class PartModel {

    private long id;

    private String name;

    private double price;

    private long quantity;

    private SupplierNameView supplier;

    public PartModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public SupplierNameView getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierNameView supplier) {
        this.supplier = supplier;
    }
}
