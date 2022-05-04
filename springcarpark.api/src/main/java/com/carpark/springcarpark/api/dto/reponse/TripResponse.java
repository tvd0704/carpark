package com.carpark.springcarpark.api.dto.reponse;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class TripResponse {


    private Long tripId;
    private Integer bookedTicketNumber;
    private String carType;
    private Date departureDate;
    private Time departureTime;
    private String destination;
    private String driver;
    private Integer maxOnlineTicketNum;

    public TripResponse() {

    }

    public TripResponse(Long tripId, Integer bookedTicketNumber, String carType, Date departureDate, Time departureTime,
                        String destination, String driver, Integer maxOnlineTicketNum) {
        this.tripId = tripId;
        this.bookedTicketNumber = bookedTicketNumber;
        this.carType = carType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.destination = destination;
        this.driver = driver;
        this.maxOnlineTicketNum = maxOnlineTicketNum;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Integer getBookedTicketNumber() {
        return bookedTicketNumber;
    }

    public void setBookedTicketNumber(Integer bookedTicketNumber) {
        this.bookedTicketNumber = bookedTicketNumber;
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
