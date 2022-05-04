package com.carpark.springcarpark.api.Controller;

import com.carpark.springcarpark.api.dto.reponse.TicketResponse;
import com.carpark.springcarpark.api.dto.request.TicketRequest;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.model.Ticket;
import com.carpark.springcarpark.api.service.Interface.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Ticket")

public class TicketController {


    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @GetMapping("/view")
    public ResponseEntity<List<TicketResponse>> getAll() {
        return new ResponseEntity<>(ticketService.viewTicket(), HttpStatus.OK);
    }

    @PostMapping("/{carId}/{tripId}")
    public ResponseEntity<TicketResponse> add(@RequestBody TicketRequest ticketRequest,
                                              @PathVariable String carId,
                                              @PathVariable Long tripId) {
        return new ResponseEntity<>(ticketService.addTicket(ticketRequest, carId, tripId),
                HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{ticketId}")
    ResponseEntity<ResponseObject> deleteTicketById(@PathVariable Long ticketId) {
        return ticketService.deleteTicketById(ticketId);
    }


}
