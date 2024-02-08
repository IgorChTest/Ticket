package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    AviaSouls avia = new AviaSouls();

    Ticket ticket1 = new Ticket(
            "Moscow",
            "Murmansk",
            5000,
            10,
            13
    );
    Ticket ticket2 = new Ticket(
            "Moscow",
            "Murmansk",
            4000,
            11,
            13
    );

    Ticket ticket3 = new Ticket(
            "Moscow",
            "Murmansk",
            4000,
            21,
            23
    );

    @Test
    public void shouldCompareTicketsMinus() {

        avia.add(ticket1);
        avia.add(ticket2);

        int expected = -1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected,actual);

    }

    @Test
    public void shouldCompareTicketsPlus() {

        avia.add(ticket1);
        avia.add(ticket3);

        int expected = 1;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldCompareTicketsEqual() {

        avia.add(ticket3);
        avia.add(ticket2);

        int expected = 0;
        int actual = ticket3.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortPriceThreeTickets() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);

        Ticket[] expected = { ticket2, ticket3, ticket1 };
        Ticket[] actual = avia.search("Moscow", "Murmansk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortPriceWithoutTickets() {

        Ticket[] expected = {};
        Ticket[] actual = avia.search("Moscow", "Murmansk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortPriceOneTicket() {

        avia.add(ticket2);

        Ticket[] expected = { ticket2 };
        Ticket[] actual = avia.search("Moscow", "Murmansk");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortTickets() {

        TicketTimeComparator comparator = new TicketTimeComparator();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);

        Ticket[] expected = {ticket2, ticket3, ticket1};
        Ticket[] actual = avia.searchAndSortBy("Moscow", "Murmansk", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
