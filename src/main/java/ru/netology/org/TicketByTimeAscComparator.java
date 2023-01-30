package ru.netology.org;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<Tickets> {
    @Override
    public int compare(Tickets o1, Tickets o2) {
        return o1.getTimeInAir() - o2.getTimeInAir();
    }
}
