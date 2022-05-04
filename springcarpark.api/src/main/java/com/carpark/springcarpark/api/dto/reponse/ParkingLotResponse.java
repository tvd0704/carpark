package com.carpark.springcarpark.api.dto.reponse;

public class ParkingLotResponse {

    private Long parkId;
    private Long parkArea;
    private String parkName;
    private String parkPlace;
    private Long parkPrice;
    private String parkStatus;

    public ParkingLotResponse() {

    }

    public ParkingLotResponse(Long parkId, Long parkArea, String parkName, String parkPlace,
                              Long parkPrice, String parkStatus) {
        this.parkId = parkId;
        this.parkArea = parkArea;
        this.parkName = parkName;
        this.parkPlace = parkPlace;
        this.parkPrice = parkPrice;
        this.parkStatus = parkStatus;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Long getParkArea() {
        return parkArea;
    }

    public void setParkArea(Long parkArea) {
        this.parkArea = parkArea;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public Long getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(Long parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }
}
