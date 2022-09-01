package ru.netology;

import ru.netology.repository.*;

public class Ticket implements Comparable<Ticket> {


    private int id;
    private int price;
    private String airportDeparture;

    public Ticket(int id, int price, String airportDeparture, String airportArrival, int travelTime) {
        this.id = id;
        this.price = price;
        this.airportDeparture = airportDeparture;
        this.airportArrival = airportArrival;
        this.travelTime = travelTime;
    }

    private String airportArrival;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(String airportDeparture) {
        this.airportDeparture = airportDeparture;
    }

    public String getAirportArrival() {
        return airportArrival;
    }

    public void setAirportArrival(String airportArrival) {
        this.airportArrival = airportArrival;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    private int travelTime;


    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;

        } else {
            return 0;

        }


    }
}
