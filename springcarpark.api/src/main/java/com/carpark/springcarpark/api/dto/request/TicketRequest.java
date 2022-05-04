package com.carpark.springcarpark.api.dto.request;

import com.carpark.springcarpark.api.model.Ticket;

import java.sql.Time;

public class TicketRequest {
    private Time bookingTime;
    private String customerName;

    public TicketRequest(Time bookingTime, String customerName) {
        this.bookingTime = bookingTime;
        this.customerName = customerName;
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
}
