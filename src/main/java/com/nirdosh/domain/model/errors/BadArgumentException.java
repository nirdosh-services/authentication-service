package com.nirdosh.domain.model.errors;

public class BadArgumentException extends ApplicationExeption {
    public BadArgumentException(String message) {
        super(message);
    }
}
