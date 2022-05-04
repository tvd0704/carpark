package com.carpark.springcarpark.api.Controller;


import com.carpark.springcarpark.api.dto.reponse.CarResponse;
import com.carpark.springcarpark.api.dto.request.CarRequest;
import com.carpark.springcarpark.api.model.Car;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.service.Interface.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Car")

public class CarController {


    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/view")
    public ResponseEntity<List<CarResponse>> getAll(CarRequest carRequest) {
        return new ResponseEntity<>(carService.viewCar(), HttpStatus.OK);
    }

    //add a new car API
    @PostMapping("/{parkId}")
    private ResponseEntity<CarResponse> add(@RequestBody CarRequest carRequest,
                                            @PathVariable Long parkId) {
        return new ResponseEntity<>(carService.addCar(carRequest, parkId),
                HttpStatus.CREATED);
    }
}
