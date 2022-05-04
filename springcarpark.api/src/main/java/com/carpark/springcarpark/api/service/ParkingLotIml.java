package com.carpark.springcarpark.api.service;

import com.carpark.springcarpark.api.dto.mapper.ParkingLotMapper;
import com.carpark.springcarpark.api.dto.reponse.ParkingLotResponse;
import com.carpark.springcarpark.api.dto.request.ParkingLotRequest;
import com.carpark.springcarpark.api.model.ParkingLot;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.repository.ParkingLotRepository;
import com.carpark.springcarpark.api.service.Interface.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ParkingLotIml  implements ParkingLotService {



    private  final  ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotIml(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    @Transactional
    public List<ParkingLotResponse> viewParkLot() {
        return parkingLotRepository.findAll().stream()
                .map(parkingLot -> ParkingLotMapper.getInstance().toDTO(parkingLot))
                .collect(Collectors.toList());
    }

    //add a new parking lot to DB
    @Override
    @Transactional
    public ParkingLotResponse addParkLot(ParkingLotRequest parkingLotRequest) {
        //convert parking lot DTO into parking lot
        ParkingLot parkToAdd = ParkingLotMapper.getInstance().toEntity(parkingLotRequest);
        return ParkingLotMapper.getInstance().toDTO(parkingLotRepository.save(parkToAdd));
    }





    @Override
    public ResponseEntity<ResponseObject> findParkingLotById(Long parkId) {

        Optional<ParkingLot> foundParkingLot = parkingLotRepository.findById(parkId);
        if(foundParkingLot.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Query Parking Lot successfully", foundParkingLot)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Not found", "Cannot find Parking Lot with parkId = "+parkId, "")
            );
        }
    }


}
