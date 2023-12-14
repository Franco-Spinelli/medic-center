package com.example.Medic.Center.exception;

public class RoomOccupiedException extends RuntimeException{
    public RoomOccupiedException() {
        super("The room is already occupied.");
    }

    public RoomOccupiedException(String message) {
        super(message);
    }
}
