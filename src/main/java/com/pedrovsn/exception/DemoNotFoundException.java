package com.pedrovsn.exception;

public class DemoNotFoundException extends RuntimeException {

    public DemoNotFoundException(Long id) {
        super("Demo " + id + " not found");
    }
}
