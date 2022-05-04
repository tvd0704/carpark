package com.carpark.springcarpark.api.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkId;

    private Long parkArea;

    private String parkName;

    private String parkPlace;

    private Long parkPrice;

    private String parkStatus;
    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private Set<Car> carSet = new HashSet<>();

    public ParkingLot() {
    }


    public ParkingLot(Long parkArea, String parkName, String parkPlace,
                      Long parkPrice, String parkStatus) {
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

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }

}
