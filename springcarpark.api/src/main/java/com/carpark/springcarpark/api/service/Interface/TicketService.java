package com.carpark.springcarpark.api.service.Interface;

import com.carpark.springcarpark.api.dto.reponse.TicketResponse;
import com.carpark.springcarpark.api.dto.request.TicketRequest;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TicketService {

    List<TicketResponse> viewTicket();

    //add a new ticket to DB
    TicketResponse addTicket(TicketRequest ticketRequest, String carId, Long tripId);
    public ResponseEntity<ResponseObject> deleteTicketById(Long ticketId);
    public ResponseEntity<ResponseObject> findTicketById(Long ticketId);




}
