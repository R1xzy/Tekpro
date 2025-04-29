package com.rifqi.tdd;

import org.junit.jupiter.api.Test;

import com.rifqi.tdd.Passenger;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void testCreateRegularPassenger() {
        Passenger passenger = new Passenger("Rifqi", false);
        assertEquals("Rifqi", passenger.getName());
        assertFalse(passenger.isVip());
    }

    @Test
    public void testCreateVipPassenger() {
        Passenger passenger = new Passenger("Rifqi", true);
        assertEquals("Rifqi", passenger.getName());
        assertTrue(passenger.isVip());
    }
}
