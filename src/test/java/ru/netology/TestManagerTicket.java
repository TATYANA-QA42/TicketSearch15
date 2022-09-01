package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestManagerTicket {
    RepositoryTicket repo = new RepositoryTicket();
    ManagerTicket manager = new ManagerTicket(repo);

    Ticket ticket1 = new Ticket(1, 2000, "ORE", "MSK", 120);
    Ticket ticket2 = new Ticket(2, 1500, "ORE", "MSK", 120);
    Ticket ticket3 = new Ticket(3, 6000, "MSK", "SPB", 120);
    Ticket ticket4 = new Ticket(4, 4500, "ORE", "MSK", 120);
    Ticket ticket5 = new Ticket(5, 500, "MSK", "SPB", 120);

    @BeforeEach
    public void setup() {
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
        manager.save(ticket5);
    }

    @Test
    public void testFindAll() {
        Ticket[] expected = {ticket2, ticket1, ticket4};
        Ticket[] actual = manager.findAll("ORE", "MSK");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testZeroFindAll() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("ERT", "MSK");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketSet() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.ticketSet();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveId() {
        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5};
        Ticket[] actual = repo.removeId(3);
        assertArrayEquals(expected, actual);
    }
}