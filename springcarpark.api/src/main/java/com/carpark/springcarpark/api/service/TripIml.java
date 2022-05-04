package com.carpark.springcarpark.api.service;

import com.carpark.springcarpark.api.dto.mapper.TripMapper;
import com.carpark.springcarpark.api.dto.reponse.TripResponse;
import com.carpark.springcarpark.api.dto.request.TripRequest;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.model.Trip;
import com.carpark.springcarpark.api.repository.TripRepository;
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
public class TripIml implements TripService {


    private final TripRepository tripRepository;

    @Autowired
    public TripIml(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }


    //get all trips exist in DB
    @Override
    @Transactional
    public List<TripResponse> viewTrip() {
        return tripRepository.findAll().stream()
                .map(trip -> TripMapper.getInstance().toDTO(trip))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TripResponse addTrip(TripRequest tripRequest) {
        Trip tripToAdd = TripMapper.getInstance().toEntity(tripRequest);
        return TripMapper.getInstance().toDTO(tripRepository.save(tripToAdd));
    }

    public ResponseEntity<ResponseObject> findTripById(Long tripId) {
        Optional<Trip> foundTrip = tripRepository.findById(tripId);
        if (foundTrip.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Query Trip successfully", foundTrip)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Not found", "Cannot find trip with tripId = " + tripId, "")
            );
        }
    }
}
