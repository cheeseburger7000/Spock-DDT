package com.example.testwithspock;

public class TooFewSidesException extends RuntimeException {
    private final int numberOfSides;
    public TooFewSidesException(String message, int numberOfSides) {
        super(message);
        this.numberOfSides = numberOfSides;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }
}
