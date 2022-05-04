package com.carpark.springcarpark.api.dto.request;

import com.carpark.springcarpark.api.model.Car;

public class CarRequest {

    private String licensePlate;
    private String carColor;
    private String carType;
    private String company;

    public CarRequest() {

    }

    public CarRequest(String licensePlate, String carColor, String carType, String company) {
        this.licensePlate = licensePlate;
        this.carColor = carColor;
        this.carType = carType;
        this.company = company;
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
}
