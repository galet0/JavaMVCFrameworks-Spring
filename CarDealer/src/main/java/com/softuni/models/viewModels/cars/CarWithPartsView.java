package com.softuni.models.viewModels.cars;


import com.softuni.models.viewModels.parts.PartViewModel;

import java.util.Set;

public class CarWithPartsView {

    private long id;

    private String make;

    private String model;

    private double travelledDistance;

    private Set<PartViewModel> parts;

    public CarWithPartsView() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<PartViewModel> getParts() {
        return parts;
    }

    public void setParts(Set<PartViewModel> parts) {
        this.parts = parts;
    }
}
