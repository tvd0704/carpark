package com.carpark.springcarpark.api.service.Interface;

import com.carpark.springcarpark.api.dto.reponse.ParkingLotResponse;
import com.carpark.springcarpark.api.dto.request.ParkingLotRequest;
import com.carpark.springcarpark.api.model.ParkingLot;
import com.carpark.springcarpark.api.model.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ParkingLotService {


    //get all parking lot
    List<ParkingLotResponse> viewParkLot();

    //add a new parking lot
    ParkingLotResponse addParkLot(ParkingLotRequest parkingLotRequest);
    public ResponseEntity<ResponseObject> findParkingLotById(Long parkId);


}
