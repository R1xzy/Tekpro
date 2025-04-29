package com.rifqi.tdd;

public class EconomyFlight extends Flight {
    public EconomyFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengers.add(passenger); // Set.add() returns boolean
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if (!passenger.isVip()) {
            return passengers.remove(passenger); // Set.remove() returns boolean
        }
        return false;
    }
}