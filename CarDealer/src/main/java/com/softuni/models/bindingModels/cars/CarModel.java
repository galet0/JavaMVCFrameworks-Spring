package com.softuni.models.bindingModels.cars;


import com.softuni.models.bindingModels.parts.PartNameModel;
import com.softuni.models.viewModels.parts.PartDetailModel;

import java.util.Set;

public class CarModel {

    private String make;

    private String model;

    private double travelledDistance;

    private Set<PartNameModel> parts;

    public CarModel() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(double travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<PartNameModel> getParts() {
        return parts;
    }

    public void setParts(Set<PartNameModel> parts) {
        this.parts = parts;
    }
}
