package com.carpark.springcarpark.api.service.Interface;

import com.carpark.springcarpark.api.dto.reponse.TripResponse;
import com.carpark.springcarpark.api.dto.request.TripRequest;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.model.Trip;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TripService {


    public ResponseEntity<ResponseObject> findTripById(Long tripId);
    public TripResponse addTrip(TripRequest tripRequest);
    List<TripResponse> viewTrip();
}
