package com.carpark.springcarpark.api.Exception;

public class NotFoundException extends  RuntimeException{


    public NotFoundException(String message) {
        super(message);
    }
}
