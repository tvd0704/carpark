package com.carpark.springcarpark.api.Controller;

import com.carpark.springcarpark.api.dto.reponse.TripResponse;
import com.carpark.springcarpark.api.dto.request.TripRequest;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.model.Trip;
import com.carpark.springcarpark.api.service.Interface.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Trip")

public class TripController {


    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }


    @GetMapping("/view")
    public ResponseEntity<List<TripResponse>> getAll() {
        return new ResponseEntity<>(tripService.viewTrip(), HttpStatus.OK);
    }

    @PostMapping("/add")
    private ResponseEntity<TripResponse> add(@RequestBody TripRequest tripRequest) {
        return new ResponseEntity<>(tripService.addTrip(tripRequest), HttpStatus.CREATED);
    }


    @GetMapping("/view/{tripId}")
    ResponseEntity<ResponseObject> viewTripById(@PathVariable Long tripId) {
        return tripService.findTripById(tripId);
    }
}
