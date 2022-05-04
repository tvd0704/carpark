package com.carpark.springcarpark.api.service.Interface;

import com.carpark.springcarpark.api.dto.reponse.CarResponse;
import com.carpark.springcarpark.api.dto.request.CarRequest;
import com.carpark.springcarpark.api.model.BookingOffice;
import com.carpark.springcarpark.api.model.Car;
import com.carpark.springcarpark.api.model.ResponseObject;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.CacheRequest;
import java.util.List;


public interface CarService {



    List<CarResponse> viewCar();

    //add a new car
    CarResponse addCar(CarRequest carRequest, Long parkId);

    public ResponseEntity<ResponseObject> findCarByLicensePlate(String licensePlate);
    public Page<Car> getCarPagination(Integer pageNumber, Integer pageSize);
    public  Page<Car> getCarSortPagination(Integer pageNumber,Integer pageSize);

}
