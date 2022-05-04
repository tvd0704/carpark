package com.carpark.springcarpark.api.Controller;

import com.carpark.springcarpark.api.dto.reponse.ParkingLotResponse;
import com.carpark.springcarpark.api.dto.request.ParkingLotRequest;
import com.carpark.springcarpark.api.model.ParkingLot;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.service.Interface.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/ParkingLot")

public class ParkingLotController {


    private  final ParkingLotService parkingLotService;
    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @GetMapping("/view")
    public ResponseEntity<List<ParkingLotResponse>> getAll() {
        return new ResponseEntity<>(parkingLotService.viewParkLot(), HttpStatus.OK);
    }

    //add a new parking lot API
    @PostMapping("/add")
    public ResponseEntity<ParkingLotResponse> add(@RequestBody ParkingLotRequest parkingLotRequest) {
        return new ResponseEntity<>(parkingLotService.addParkLot(parkingLotRequest), HttpStatus.CREATED);
    }



}
