package com.carpark.springcarpark.api.dto.mapper;

import com.carpark.springcarpark.api.dto.reponse.TripResponse;
import com.carpark.springcarpark.api.dto.request.TripRequest;
import com.carpark.springcarpark.api.model.Trip;

public class TripMapper {


    private static TripMapper INSTANCE;

    //Get a trip mapper instance
    public static TripMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TripMapper();
        }
        return INSTANCE;
    }

    //convert DTO into Entity
    public Trip toEntity(TripRequest tripRequest) {
        Trip trip = new Trip();
        trip.setCarType(tripRequest.getCarType());
        trip.setDepartureDate(tripRequest.getDepartureDate());
        trip.setDepartureTime(tripRequest.getDepartureTime());
        trip.setDestination(tripRequest.getDestination());
        trip.setDriver(tripRequest.getDriver());
        trip.setMaxOnlineTicketNum(tripRequest.getMaxOnlineTicketNum());
        return trip;
    }


    public TripResponse toDTO(Trip trip) {
        TripResponse tripResponse = new TripResponse();
        tripResponse.setTripId(trip.getTripId());
        tripResponse.setBookedTicketNumber(trip.getBookedTicketNumber());
        tripResponse.setCarType(trip.getCarType());
        tripResponse.setDepartureDate(trip.getDepartureDate());
        tripResponse.setDepartureTime(trip.getDepartureTime());
        tripResponse.setDestination(trip.getDestination());
        tripResponse.setDriver(trip.getDriver());
        tripResponse.setMaxOnlineTicketNum(trip.getMaxOnlineTicketNum());
        return tripResponse;
    }

}
