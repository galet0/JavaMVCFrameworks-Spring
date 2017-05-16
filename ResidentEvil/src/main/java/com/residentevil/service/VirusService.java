package com.residentevil.service;


import com.residentevil.models.bindingModels.VirusBindingModel;

public interface VirusService {

    void create(VirusBindingModel virusBindingModel);

    String getGeoData();
}
