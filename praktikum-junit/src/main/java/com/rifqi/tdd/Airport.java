package com.rifqi.tdd;

public class Airport {
    public static void main(String[] args) {
        Flight economyFlight = new EconomyFlight("1");
        Passenger james = new Passenger("James", false);
        Passenger mike = new Passenger("Mike", true);

        System.out.println("Economy Flight:");
        System.out.println("Add James: " + economyFlight.addPassenger(james));
        System.out.println("Add Mike: " + economyFlight.addPassenger(mike));
    }
}
