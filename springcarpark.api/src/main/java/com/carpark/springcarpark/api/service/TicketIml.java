package com.carpark.springcarpark.api.service;

import com.carpark.springcarpark.api.Exception.NotFoundException;
import com.carpark.springcarpark.api.Exception.TripCapabilityException;
import com.carpark.springcarpark.api.dto.mapper.TicketMapper;
import com.carpark.springcarpark.api.dto.reponse.TicketResponse;
import com.carpark.springcarpark.api.dto.request.TicketRequest;
import com.carpark.springcarpark.api.model.Car;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.model.Ticket;
import com.carpark.springcarpark.api.model.Trip;
import com.carpark.springcarpark.api.repository.CarRepository;
import com.carpark.springcarpark.api.repository.TicketRepository;
import com.carpark.springcarpark.api.repository.TripRepository;
import com.carpark.springcarpark.api.service.Interface.CarService;
import com.carpark.springcarpark.api.service.Interface.TicketService;
import com.carpark.springcarpark.api.service.Interface.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TicketIml implements TicketService {





    private TicketRepository ticketRepository;
    private CarRepository carRepository;
    private TripRepository tripRepository;


    public TicketIml(TicketRepository ticketRepository, CarRepository carRepository, TripRepository tripRepository) {
        this.ticketRepository = ticketRepository;
        this.carRepository = carRepository;
        this.tripRepository = tripRepository;
    }

    @Autowired



    @Override
    @Transactional
    public List<TicketResponse> viewTicket() {
        return ticketRepository.findAll().stream()
                .map(ticket -> TicketMapper.getInstance().toDTO(ticket))
                .collect(Collectors.toList());
    }

    //add a new ticket to DB
    @Override
    @Transactional
    public TicketResponse addTicket(TicketRequest ticketRequest,
                                    String carId, Long tripId) {
        //check if the car exists in DB
        if (carRepository.existsById(carId)) {
            Car car = carRepository.getById(carId);
            //convert ticket DTO into ticket
            Ticket ticket = TicketMapper.getInstance().toEntity(ticketRequest);
            //add car's information to the ticket
            ticket.setCar(car);
            //check if the trip exists in DB
            if (tripRepository.existsById(tripId)) {
                //get the trip to validate information
                Trip trip = tripRepository.getById(tripId);
                //check if the number of booked tickets is valid
                if (trip.getBookedTicketNumber() < trip.getMaxOnlineTicketNum()) {
                    ticket.setTrip(trip);
                    //increase the number of booked tickets by 1 and update to DB
                    trip.setBookedTicketNumber(trip.getBookedTicketNumber() + 1);
                    tripRepository.save(trip);
                    return TicketMapper.getInstance().toDTO(ticketRepository.save(ticket));
                } else {
                    throw new TripCapabilityException("Error! Trip has been full");
                }
            } else {
                throw new NotFoundException("Error! No trip with the given ID was found");
            }

        } else {
            throw new NotFoundException("Error! No car with the license plate was found");
        }
    }


    @Override
    public ResponseEntity<ResponseObject> deleteTicketById(Long ticketId) {

        Optional<Ticket> ticketOptional = (Optional<Ticket>) findTicketById(ticketId).getBody().getData();
        Ticket foundTicket = ticketOptional.get();
        ticketRepository.deleteById(ticketId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Delete Ticket Successfully", foundTicket)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> findTicketById(Long ticketId) {

        Optional<Ticket> foundTicket = ticketRepository.findById(ticketId);
        if(foundTicket.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Query Trip successfully", foundTicket)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Not found", "Cannot find Ticket with ticketId = "+ticketId, "")
            );
        }



    }
}
