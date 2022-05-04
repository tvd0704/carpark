package com.carpark.springcarpark.api.dto.reponse;

public class CarResponse {


    private String licensePlate;
    private String carColor;
    private String carType;
    private String company;
    private ParkingLotResponse parkingLotResponse;

    public CarResponse() {

    }

    public CarResponse(String licensePlate, String carColor, String carType, String company,
                       ParkingLotResponse parkingLotResponse) {
        this.licensePlate = licensePlate;
        this.carColor = carColor;
        this.carType = carType;
        this.company = company;
        this.parkingLotResponse = parkingLotResponse;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ParkingLotResponse getParkingLotResponse() {
        return parkingLotResponse;
    }

    public void setParkingLotResponse(ParkingLotResponse parkingLotResponse) {
        this.parkingLotResponse = parkingLotResponse;
    }
}
