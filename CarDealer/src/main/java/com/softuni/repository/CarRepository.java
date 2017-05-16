package com.softuni.repository;


import com.softuni.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> getAllByMakeOrderByModelAscTravelledDistanceDesc(String make);

    List<Car> getAllByOrderByModelAscTravelledDistanceDesc();

//    @Modifying
//    @Query(value = "UPDATE Car SET make = :make, model = :model, travelledDistance = :travelledDistance, id = :id")
//    void updateCar(@Param("make") String make,
//                   @Param("model") String model,
//                   @Param("travelledDistance") double travelledDistance,
//                   @Param("id") long id);

}
