package com.carpark.springcarpark.api.Controller;

import com.carpark.springcarpark.api.dto.reponse.BookingOfficeReponse;
import com.carpark.springcarpark.api.dto.request.BookingOfficeRequest;
import com.carpark.springcarpark.api.model.BookingOffice;
import com.carpark.springcarpark.api.model.ResponseObject;
import com.carpark.springcarpark.api.service.Interface.BookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/BookingOffice")

public class BookingOfficeController {


    private final BookingOfficeService bookingService;

    @Autowired
    public BookingOfficeController(BookingOfficeService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping("/{tripId}")
    private ResponseEntity<BookingOfficeReponse> add(@RequestBody BookingOfficeRequest bookingOfficeRequest,
                                                     @PathVariable Long tripId) {
        return new ResponseEntity<>(bookingService.addBookOffice(bookingOfficeRequest, tripId),
                HttpStatus.CREATED);
    }

    @GetMapping("/viewAllBookingList")
    ResponseEntity<ResponseObject> viewAllBooking() {
        return bookingService.findAllBooking();
    }


}
