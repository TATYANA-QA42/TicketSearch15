package ru.netology;

import ru.netology.repository.*;

import static java.lang.System.in;

import java.util.Arrays;
import java.util.Objects;

public class ManagerTicket {
    private RepositoryTicket repo;

    public ManagerTicket(RepositoryTicket repo) {
        this.repo = repo;
    }

    public void save(Ticket ticket) {
        repo.add(ticket);
    }

    public Ticket[] findAll(String airportDeparture, String airportArrival) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.ticketSet()) {
            if (Objects.equals(ticket.getAirportArrival(), airportArrival) && Objects.equals(ticket.getAirportDeparture(), airportDeparture)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket; //[tmp.length - 1]
                result = tmp;

            }
            Arrays.sort(result);
        }
        return result;
    }
//public Ticket[] findAll(String from, String to) {
//    Ticket[] result = new Ticket[0];               // тут будем хранить подошедшие запросу продукты
//    for (Ticket ticket : repo.ticketSet()) {
//        if (matches(ticket, from, to)) {
//            Ticket[] tmp = new Ticket[result.length + 1];
//            for (int i = 0; i < result.length; i++) {
//                tmp[i] = result[i];
//            }
//            tmp[tmp.length - 1] = ticket;
//            result = tmp;
//        }
//        Arrays.sort(result);
//    }
//    return result;
//}
//    public boolean matches(Ticket ticket, String from, String to) {
//        if (ticket.getAirportDeparture().contains(from)) {
//            return true;
//        } else if (ticket.getAirportArrival().contains(to)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
