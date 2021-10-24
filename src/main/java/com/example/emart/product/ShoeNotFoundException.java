package com.example.emart.product;

public class ShoeNotFoundException extends Throwable {
    public ShoeNotFoundException(String message) {
        super(message);
    }
}
