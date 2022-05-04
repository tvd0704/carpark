package com.carpark.springcarpark.api.dto.reponse;

import java.sql.Time;
import java.time.LocalTime;

public class TicketResponse {

    private Long ticketId;
    private Time bookingTime;
    private String customerName;
    private CarResponse carResponse;
    private TripResponse tripResponse;

    public TicketResponse() {

    }

    public TicketResponse(Long ticketId, Time bookingTime, String customerName, CarResponse carResponse,
                          TripResponse tripResponse) {
        this.ticketId = ticketId;
        this.bookingTime = bookingTime;
        this.customerName = customerName;
        this.carResponse = carResponse;
        this.tripResponse = tripResponse;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CarResponse getCarResponse() {
        return carResponse;
    }

    public void setCarResponse(CarResponse carResponse) {
        this.carResponse = carResponse;
    }

    public TripResponse getTripResponse() {
        return tripResponse;
    }

    public void setTripResponse(TripResponse tripResponse) {
        this.tripResponse = tripResponse;
    }
}
