package com.carpark.springcarpark.api.service.Interface;


import com.carpark.springcarpark.api.dto.reponse.BookingOfficeReponse;
import com.carpark.springcarpark.api.dto.request.BookingOfficeRequest;
import com.carpark.springcarpark.api.model.BookingOffice;
import com.carpark.springcarpark.api.model.Employee;
import com.carpark.springcarpark.api.model.ResponseObject;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface BookingOfficeService {


    public BookingOfficeReponse addBookOffice(BookingOfficeRequest bookingOfficeRequest, Long tripId);
    public ResponseEntity<ResponseObject> findAllBooking();
    public Page<BookingOffice> getBookingPagination(Integer pageNumber, Integer pageSize);
    public  Page<BookingOffice> getBookingSortPagination(Integer pageNumber,Integer pageSize);


}
