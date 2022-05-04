package com.carpark.springcarpark.api.dto.request;

import com.carpark.springcarpark.api.model.Trip;

import java.sql.Time;
import java.util.Date;

public class TripRequest {


    private String carType;
    private Date departureDate;
    private Time departureTime;
    private String destination;
    private String driver;
    private Integer maxOnlineTicketNum;

    public TripRequest() {

    }

    public TripRequest(String carType, Date departureDate, Time departureTime,
                       String destination, String driver, Integer maxOnlineTicketNum) {
        this.carType = carType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.driver = driver;
        this.maxOnlineTicketNum = maxOnlineTicketNum;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Integer getMaxOnlineTicketNum() {
        return maxOnlineTicketNum;
    }

    public void setMaxOnlineTicketNum(Integer maxOnlineTicketNum) {
        this.maxOnlineTicketNum = maxOnlineTicketNum;
    }
}
