package com.softuni.service;


import com.softuni.models.bindingModels.cars.CarModel;
import com.softuni.models.bindingModels.cars.EditCarModel;
import com.softuni.models.viewModels.cars.CarViewModel;
import com.softuni.models.viewModels.cars.CarWithPartsView;

import java.util.List;

public interface CarService {

    List<CarViewModel> getAllByMake(String make);

//    Set<CarWithPartsView> getAllCars();

    CarWithPartsView getById(long id);

    void create(CarModel carModel);

//    void updateCar(String make, String model, double travelledDistance, long id);
//
//    EditCarModel getByIdToEdit(long id);
}
