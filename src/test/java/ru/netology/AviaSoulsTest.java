package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest{

    @Test
    public void shouldCompareWhenT1LowerT2(){
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 5600, 8, 9);
        Ticket ticket2 = new Ticket("Kazan", "St.Petersburg", 6200, 9, 11);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldCompareWhenT2LowerT1(){
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 5600, 8, 9);
        Ticket ticket2 = new Ticket("Kazan", "St.Petersburg", 6200, 9, 11);

        int expected = 1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareWhenT1EqualT2(){
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 6200, 8, 9);
        Ticket ticket2 = new Ticket("Kazan", "St.Petersburg", 6200, 9, 11);

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByPrice(){
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 6500, 8, 9);
        Ticket ticket2 = new Ticket("Kazan", "Moscow", 6200, 23, 24);
        Ticket ticket3 = new Ticket("Kazan", "Moscow", 6350, 16, 17);
        Ticket ticket4 = new Ticket("Kazan", "Moscow", 6850, 15, 16);
        Ticket ticket5 = new Ticket("Kazan", "Moscow", 6100, 18, 20);

        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket5,ticket2, ticket3, ticket1, ticket4};
        Ticket[] actual = manager.search("Kazan", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TicketTimeComparatorTest(){
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 6500, 8, 9);
        Ticket ticket2 = new Ticket("Kazan", "St.Petersburg", 6800, 20, 24);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = -1;
        int actual = timeComparator.compare(ticket1,ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSearchAndSortByFlightTime(){
        Ticket ticket1 = new Ticket("Kazan", "Moscow", 6500, 8, 9); // 1 hour
        Ticket ticket2 = new Ticket("Kazan", "Moscow", 6200, 21, 24); // 3 hours
        Ticket ticket3 = new Ticket("Kazan", "Moscow", 6350, 15, 17); // 2 hours
        Ticket ticket4 = new Ticket("Kazan", "Moscow", 6850, 11, 18); // 5 hours
        Ticket ticket5 = new Ticket("Kazan", "Moscow", 6100, 16, 17); // 1 hour

        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket5, ticket3, ticket2, ticket4};
        Ticket[] actual = manager.searchAndSortBy("Kazan", "Moscow", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
