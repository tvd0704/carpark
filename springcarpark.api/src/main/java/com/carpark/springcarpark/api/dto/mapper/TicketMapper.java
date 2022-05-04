package com.carpark.springcarpark.api.dto.mapper;

import com.carpark.springcarpark.api.dto.reponse.CarResponse;
import com.carpark.springcarpark.api.dto.reponse.TicketResponse;
import com.carpark.springcarpark.api.dto.reponse.TripResponse;
import com.carpark.springcarpark.api.dto.request.TicketRequest;
import com.carpark.springcarpark.api.model.Ticket;

public class TicketMapper {

    private static TicketMapper INSTANCE;

    //Get a ticket mapper instance
    public static TicketMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TicketMapper();
        }
        return INSTANCE;
    }

    //Convert DTO into Entity
    public Ticket toEntity(TicketRequest ticketRequest) {
        Ticket ticket = new Ticket();
        ticket.setBookingTime(ticketRequest.getBookingTime());
        ticket.setCustomerName(ticketRequest.getCustomerName());
        return ticket;
    }


    public TicketResponse toDTO(Ticket ticket) {
        TicketResponse ticketResponse = new TicketResponse();
        ticketResponse.setTicketId(ticket.getTicketId());
        ticketResponse.setBookingTime(ticket.getBookingTime());
        ticketResponse.setCustomerName(ticket.getCustomerName());
        CarResponse carResponse = CarMapper.getInstance().toDTO(ticket.getCar());
        TripResponse tripResponse = TripMapper.getInstance().toDTO(ticket.getTrip());
        ticketResponse.setCarResponse(carResponse);
        ticketResponse.setTripResponse(tripResponse);
        return ticketResponse;
    }
}
