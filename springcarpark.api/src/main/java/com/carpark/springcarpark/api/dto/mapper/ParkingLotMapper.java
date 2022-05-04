package com.carpark.springcarpark.api.dto.mapper;

import com.carpark.springcarpark.api.dto.reponse.ParkingLotResponse;
import com.carpark.springcarpark.api.dto.request.ParkingLotRequest;
import com.carpark.springcarpark.api.model.Car;
import com.carpark.springcarpark.api.model.ParkingLot;

public class ParkingLotMapper {

    private static ParkingLotMapper INSTANCE;

    //Get a parking mapper instance
    public static ParkingLotMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ParkingLotMapper();
        }
        return INSTANCE;
    }


    //Convert DTO into Entity
    public ParkingLot toEntity(ParkingLotRequest parkingLotRequest) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkArea(parkingLotRequest.getParkArea());
        parkingLot.setParkName(parkingLotRequest.getParkName());
        parkingLot.setParkPlace(parkingLotRequest.getParkPlace());
        parkingLot.setParkPrice(parkingLotRequest.getParkPrice());
        parkingLot.setParkStatus(parkingLotRequest.getParkStatus());
        return parkingLot;
    }

    //Convert Entity into DTO
    public ParkingLotResponse toDTO(ParkingLot parkingLot) {
        ParkingLotResponse parkingLotResponse=new ParkingLotResponse();

        parkingLotResponse.setParkId(parkingLot.getParkId());
        parkingLotResponse.setParkArea(parkingLot.getParkArea());
        parkingLotResponse.setParkName(parkingLot.getParkName());
        parkingLotResponse.setParkPlace(parkingLot.getParkPlace());
        parkingLotResponse.setParkPrice(parkingLot.getParkPrice());
        parkingLotResponse.setParkStatus(parkingLot.getParkStatus());
        return parkingLotResponse;
    }


}
