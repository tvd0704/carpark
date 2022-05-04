package com.carpark.springcarpark.api.dto.mapper;

import com.carpark.springcarpark.api.dto.reponse.BookingOfficeReponse;
import com.carpark.springcarpark.api.dto.reponse.TripResponse;
import com.carpark.springcarpark.api.dto.request.BookingOfficeRequest;
import com.carpark.springcarpark.api.model.BookingOffice;

public class BookingOfficeMapper {
    private static BookingOfficeMapper INSTANCE;

    //Get an office mapper instance
    public static BookingOfficeMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookingOfficeMapper();
        }
        return INSTANCE;
    }

    //convert dto to entity
    public BookingOffice toEntity(BookingOfficeRequest bookingOfficeRequest) {
        BookingOffice bookingOffice = new BookingOffice();
        bookingOffice.setEndContractDeadline(bookingOfficeRequest.getEndContractDeadline());
        bookingOffice.setOfficeName(bookingOfficeRequest.getOfficeName());
        bookingOffice.setOfficePhone(bookingOfficeRequest.getOfficePhone());
        bookingOffice.setOfficePlace(bookingOfficeRequest.getOfficePlace());
        bookingOffice.setOfficePrice(bookingOfficeRequest.getOfficePrice());
        bookingOffice.setStartContractDeadline(bookingOfficeRequest.getStartContractDeadline());
        return bookingOffice;
    }

    public BookingOfficeReponse toDTO(BookingOffice bookingOffice) {
        BookingOfficeReponse bookingOfficeReponse = new BookingOfficeReponse();
        bookingOfficeReponse.setOfficeId(bookingOffice.getOfficeId());
        bookingOfficeReponse.setEndContractDeadline(bookingOffice.getEndContractDeadline());
        bookingOfficeReponse.setOfficeName(bookingOffice.getOfficeName());
        bookingOfficeReponse.setOfficePhone(bookingOffice.getOfficePhone());
        bookingOfficeReponse.setOfficePlace(bookingOffice.getOfficePlace());
        bookingOfficeReponse.setOfficePrice(bookingOffice.getOfficePrice());
        bookingOfficeReponse.setStartContractDeadline(bookingOffice.getStartContractDeadline());
        TripResponse tripResponse = TripMapper.getInstance().toDTO(bookingOffice.getTrip());
        bookingOfficeReponse.setTripResponse(tripResponse);
        return bookingOfficeReponse;
    }


}
