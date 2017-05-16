package com.softuni.models.viewModels.suppliers;


import com.softuni.models.viewModels.parts.PartViewModel;

import java.util.Set;

public class SupplierViewModel {

    private long id;

    private String name;

    private Set<PartViewModel> parts;

    public SupplierViewModel() {
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

    public Set<PartViewModel> getParts() {
        return parts;
    }

    public void setParts(Set<PartViewModel> parts) {
        this.parts = parts;
    }
}
