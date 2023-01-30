package ru.netology.org;

import java.util.Arrays;
import java.util.Comparator;

public class TicketsManager {
    private TicketsRepository repo;

    public TicketsManager(TicketsRepository repo) {
        this.repo = repo;
    }

    public void add(Tickets tickets) {
        repo.save(tickets);
    }

    public Tickets[] searchBy(String departurePort, String arrivalPort) {
        Tickets[] result = new Tickets[0];
        for (Tickets tickets : repo.getAll()) {
            if (matches(tickets, departurePort, arrivalPort)) {
                Tickets[] tmp = new Tickets[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = tickets;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Tickets[] searchBy(String departurePort, String arrivalPort, Comparator<Tickets> comparator) {
        Tickets[] result = new Tickets[0];
        for (Tickets tickets : repo.getAll()) {
            if (matches(tickets, departurePort, arrivalPort)) {
                Tickets[] tmp = new Tickets[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = tickets;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public boolean matches(Tickets tickets, String departurePort, String arrivalPort) {
        if (tickets.getDeparturePort().equals(departurePort)) {
            if (tickets.getArrivalPort().equals(arrivalPort)) {
                return true;
            }
        }
        return false;
    }
}