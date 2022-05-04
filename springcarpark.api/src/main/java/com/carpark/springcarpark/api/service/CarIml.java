package com.carpark.springcarpark.api.service;

import com.carpark.springcarpark.api.Exception.DuplicatedException;
import com.carpark.springcarpark.api.Exception.NotFoundException;
import com.carpark.springcarpark.api.dto.mapper.CarMapper;
import com.carpark.springcarpark.api.dto.reponse.CarResponse;
import com.carpark.springcarpark.api.dto.request.CarRequest;
import com.carpark.springcarpark.api.model.BookingOffice;
import com.carpark.springcarpark.api.model.Car;
import com.carpark.springcarpark.api.model.ParkingLot;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.repository.CarRepository;
import com.carpark.springcarpark.api.repository.ParkingLotRepository;
import com.carpark.springcarpark.api.service.Interface.CarService;
import com.carpark.springcarpark.api.service.Interface.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarIml implements CarService {


    private final CarRepository carRepository;

      private  final ParkingLotRepository parkingLotRepository;
  @Autowired
    public CarIml(CarRepository carRepository, ParkingLotRepository parkingLotRepository) {
        this.carRepository = carRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    @Transactional
    public List<CarResponse> viewCar() {
        return carRepository.findAll().stream()
                .map(car -> CarMapper.getInstance().toDTO(car))
                .collect(Collectors.toList());
    }

    //add a new car to DB
    @Override
    @Transactional
    public CarResponse addCar(CarRequest carRequest, Long parkId) {
        //check if there is any car with the ID exists in DB
        if (!this.carRepository.existsById(carRequest.getLicensePlate())) {
            ParkingLot parkingLot = parkingLotRepository.findById(parkId).
                    orElseThrow(() -> new NotFoundException("Error! No parking lot with the given ID was found"));
            Car carToAdd = CarMapper.getInstance().toEntity(carRequest);
            carToAdd.setParkingLot(parkingLot);
            return CarMapper.getInstance().toDTO(carRepository.save(carToAdd));
        } else {
            throw new DuplicatedException("Error! License plate has already existed");
        }
    }



    public ResponseEntity<ResponseObject> findCarByLicensePlate(String licensePlate) {
        Optional<Car> foundCar = carRepository.findById(licensePlate);
        if(foundCar.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Query Car successfully", foundCar)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Not found", "Cannot find Car with license plate = "+licensePlate, "")
            );
        }
    }

    @Override
    @Transactional
    public Page<Car> getCarPagination(Integer pageNumber, Integer pageSize) {

        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return carRepository.findAll(pageable);

    }

    @Override
    public Page<Car> getCarSortPagination(Integer pageNumber, Integer pageSize) {

        Sort sort=Sort.by(Sort.Direction.ASC,"officeName");
        Pageable pageable=PageRequest.of(pageNumber,pageSize);
        return carRepository.findAll(pageable);
    }




}