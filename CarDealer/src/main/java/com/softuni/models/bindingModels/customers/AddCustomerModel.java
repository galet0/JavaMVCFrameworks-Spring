package com.softuni.models.bindingModels.customers;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AddCustomerModel {

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private boolean isYoungDriver;

    public AddCustomerModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
