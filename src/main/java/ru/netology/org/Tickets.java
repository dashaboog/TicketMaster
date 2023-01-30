package ru.netology.org;

public class Tickets implements Comparable<Tickets> {
    protected int id;
    protected int price;
    protected String departurePort;
    protected String arrivalPort;
    protected int timeInAir;

    public Tickets(int id, int price, String departurePort, String arrivalPort, int timeInAir) {
        this.id = id;
        this.price = price;
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.timeInAir = timeInAir;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    @Override
    public int compareTo(Tickets o) {
        if (price < o.getPrice()) {
            return -1;
        }
        if (price > o.getPrice()) {
            return 1;
        }
        return 0;
    }
}
