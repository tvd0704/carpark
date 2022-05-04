package com.carpark.springcarpark.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long tripId;

    private static Integer bookedTicketNumber=0;

    private String carType;

    private Date departureDate;

    private Time departureTime;

    private String destination;

    private String driver;

    private Integer maxOnlineTicketNum;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private Set<BookingOffice> bookingOfficeSet = new HashSet<>();

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private Set<Ticket> ticketSet = new HashSet<>();

    public Trip() {
    }


    public Trip(Integer bookedTicketNumber, String carType,
                Date departureDate, Time departureTime,
                String destination, String driver,
                Integer maxOnlineTicketNum) {
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

    public Set<BookingOffice> getBookingOfficeSet() {
        return bookingOfficeSet;
    }

    public void setBookingOfficeSet(Set<BookingOffice> bookingOfficeSet) {
        this.bookingOfficeSet = bookingOfficeSet;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

}
