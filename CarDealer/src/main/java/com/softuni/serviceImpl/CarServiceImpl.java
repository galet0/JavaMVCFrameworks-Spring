package com.softuni.serviceImpl;

import com.softuni.entities.Car;
import com.softuni.models.bindingModels.cars.CarModel;
import com.softuni.models.bindingModels.cars.EditCarModel;
import com.softuni.models.viewModels.cars.CarViewModel;
import com.softuni.models.viewModels.cars.CarWithPartsView;
import com.softuni.repository.CarRepository;
import com.softuni.service.CarService;
import com.softuni.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelParser modelParser;


    @Override
    public List<CarViewModel> getAllByMake(String make) {
        List<Car> cars = new ArrayList<>();
        if(make != null){
            cars = this.carRepository.getAllByMakeOrderByModelAscTravelledDistanceDesc(make);
        } else {
            cars = this.carRepository.getAllByOrderByModelAscTravelledDistanceDesc();
        }

        List<CarViewModel> carViewModels = new ArrayList<>();
        for (Car car : cars) {
            CarViewModel carViewModel = this.modelParser.convert(car, CarViewModel.class);
            carViewModels.add(carViewModel);
        }
        return carViewModels;
    }

    @Override
    public CarWithPartsView getById(long id) {
        Car car = this.carRepository.findOne(id);
        CarWithPartsView carWithPartsView = this.modelParser.convert(car, CarWithPartsView.class);
        return carWithPartsView;
    }

    @Override
    public void create(CarModel carModel) {
        Car car = this.modelParser.convert(carModel, Car.class);
        this.carRepository.saveAndFlush(car);
    }

//    @Override
//    public void updateCar(String make, String model, double travelledDistance, long id) {
//        this.carRepository.updateCar(make, model, travelledDistance, id);
//    }
//
//    @Override
//    public EditCarModel getByIdToEdit(long id) {
//        Car car = this.carRepository.findOne(id);
//        EditCarModel modifiableCarModel = this.modelParser.convert(car, EditCarModel.class);
//        return modifiableCarModel;
//    }


}
