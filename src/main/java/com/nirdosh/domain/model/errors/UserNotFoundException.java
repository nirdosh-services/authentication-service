package com.nirdosh.domain.model.errors;

public class UserNotFoundException extends ApplicationExeption {

    public UserNotFoundException(String message){
        super(message);
    }
}
