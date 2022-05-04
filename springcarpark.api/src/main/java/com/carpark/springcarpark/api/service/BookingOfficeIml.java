package com.carpark.springcarpark.api.service;

import com.carpark.springcarpark.api.Exception.NotFoundException;
import com.carpark.springcarpark.api.dto.mapper.BookingOfficeMapper;
import com.carpark.springcarpark.api.dto.reponse.BookingOfficeReponse;
import com.carpark.springcarpark.api.dto.request.BookingOfficeRequest;
import com.carpark.springcarpark.api.model.BookingOffice;
import com.carpark.springcarpark.api.model.Employee;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.model.Trip;
import com.carpark.springcarpark.api.repository.BookingOfficeRepository;
import com.carpark.springcarpark.api.repository.TripRepository;
import com.carpark.springcarpark.api.service.Interface.BookingOfficeService;
import com.carpark.springcarpark.api.service.Interface.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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


@Service
public class BookingOfficeIml implements BookingOfficeService {



    private  final BookingOfficeRepository bookingOfficeRepository;


    private  final TripRepository tripRepository;




  @Autowired
    public BookingOfficeIml(BookingOfficeRepository bookingOfficeRepository, TripRepository tripRepository) {
        this.bookingOfficeRepository = bookingOfficeRepository;
        this.tripRepository = tripRepository;

    }


    @Override
    @Transactional
    public BookingOfficeReponse addBookOffice(BookingOfficeRequest bookingOfficeRequest, Long tripId) {
        //check if the Office exists
        if (tripRepository.existsById(tripId)) {
            Trip trip = tripRepository.getById(tripId);
            BookingOffice officeToAdd = BookingOfficeMapper.getInstance().toEntity(bookingOfficeRequest);
            officeToAdd.setTrip(trip);
            return BookingOfficeMapper.getInstance().toDTO(bookingOfficeRepository.save(officeToAdd));
        } else {
            throw new NotFoundException("Error! No trip with the given ID was found");
        }
    }

    @Override
    public ResponseEntity<ResponseObject> findAllBooking() {
        List<BookingOffice> bookingOfficeList = bookingOfficeRepository.findAll();
        if(!bookingOfficeList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Query All Booking Offices successfully", bookingOfficeList)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Not found", "Cannot find any Booking Offices", "")
            );
        }
    }


    @Override
    @Transactional
    public Page<BookingOffice> getBookingPagination(Integer pageNumber, Integer pageSize) {

        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return bookingOfficeRepository.findAll(pageable);

    }

    @Override
    public Page<BookingOffice> getBookingSortPagination(Integer pageNumber, Integer pageSize) {

        Sort sort=Sort.by(Sort.Direction.ASC,"officeName");
        Pageable pageable=PageRequest.of(pageNumber,pageSize);
        return bookingOfficeRepository.findAll(pageable);
    }


}
