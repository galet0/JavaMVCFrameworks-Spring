package com.softuni.models.bindingModels.customers;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EditCustomerModel {

    private long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private boolean isYoungDriver;

    public EditCustomerModel() {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean getIsYoungDriver() {
        return isYoungDriver;
    }

    public void setIsYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
