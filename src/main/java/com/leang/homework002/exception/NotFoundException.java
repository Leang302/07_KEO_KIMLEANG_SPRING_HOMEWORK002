package com.leang.homework002.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message+" not found.");
    }
}
