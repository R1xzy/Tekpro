package com.rifqi.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @Test
    public void testEconomyFlightWithRegularPassenger() {
        Flight economyFlight = new EconomyFlight("1");
        Passenger mike = new Passenger("Mike", false);

        assertTrue(economyFlight.addPassenger(mike));
        assertEquals(1, economyFlight.getPassengers().size());
        assertTrue(economyFlight.removePassenger(mike));
        assertEquals(0, economyFlight.getPassengers().size());
    }

    @Test
    public void testBusinessFlightWithRegularPassenger() {
        Flight businessFlight = new BusinessFlight("2");
        Passenger mike = new Passenger("Mike", false);

        assertFalse(businessFlight.addPassenger(mike));
        assertEquals(0, businessFlight.getPassengers().size());
    }

    @Test
    public void testBusinessFlightWithVipPassenger() {
        Flight businessFlight = new BusinessFlight("2");
        Passenger john = new Passenger("John", true);

        assertTrue(businessFlight.addPassenger(john));
        assertEquals(1, businessFlight.getPassengers().size());
        assertFalse(businessFlight.removePassenger(john));
    }
}
