package com.carpark.springcarpark.api.dto.mapper;

import com.carpark.springcarpark.api.dto.reponse.CarResponse;
import com.carpark.springcarpark.api.dto.reponse.ParkingLotResponse;
import com.carpark.springcarpark.api.dto.request.CarRequest;
import com.carpark.springcarpark.api.model.Car;

public class CarMapper {

    private static CarMapper INSTANCE;

    //Get a car mapper instance
    public static CarMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CarMapper();
        }
        return INSTANCE;
    }


    //Convert DTO into Entity
    public Car toEntity(CarRequest carRequest) {
        Car car = new Car();
        car.setLicensePlate(carRequest.getLicensePlate());
        car.setCarColor(carRequest.getCarColor());
        car.setCarType(carRequest.getCarType());
        car.setCompany(carRequest.getCompany());
        return car;
    }

    public CarResponse toDTO(Car car) {
        CarResponse carResponse=new CarResponse();
        carResponse.setLicensePlate(car.getLicensePlate());
        carResponse.setCarColor(car.getCarColor());
        carResponse.setCarType(car.getCarType());
        carResponse.setCompany(car.getCompany());
        ParkingLotResponse parkingLotResponse = ParkingLotMapper.getInstance()
                .toDTO(car.getParkingLot());
        carResponse.setParkingLotResponse(parkingLotResponse);
        return carResponse;
    }



}
