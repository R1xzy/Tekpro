package com.rifqi.tdd;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Flight {
    private String id;
    protected Set<Passenger> passengers = new HashSet<>();

    public Flight(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Set<Passenger> getPassengers() {
        return Collections.unmodifiableSet(passengers);
    }

    public int getPassengerCount() {
        return passengers.size();
    }

    public abstract boolean addPassenger(Passenger passenger);
    public abstract boolean removePassenger(Passenger passenger);
}