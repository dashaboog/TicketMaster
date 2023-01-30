import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.org.TicketByTimeAscComparator;
import ru.netology.org.Tickets;
import ru.netology.org.TicketsManager;
import ru.netology.org.TicketsRepository;

public class TicketsTest {
    TicketsRepository repo = new TicketsRepository();
    TicketsManager manager = new TicketsManager(repo);

    Tickets ticket1 = new Tickets(5688965, 50000, "MSC", "DBX", 360);
    Tickets ticket2 = new Tickets(5759989, 150000, "LAX", "MSC", 900);
    Tickets ticket3 = new Tickets(8976785, 78000, "LND", "TKY", 800);
    Tickets ticket4 = new Tickets(8745667, 15000, "PRS", "BRL", 100);
    Tickets ticket5 = new Tickets(9766483, 45000, "MSC", "SPB", 300);
    Tickets ticket6 = new Tickets(2353467, 65000, "MSC", "SPB", 96);
    Tickets ticket7 = new Tickets(1234566, 25000, "MSC", "SPB", 99);
    Tickets ticket8 = new Tickets(1111111, 50000, "MSC", "DBX", 360);
    Tickets ticket9 = new Tickets(2222222, 160000, "LAX", "MSC", 900);

    @BeforeEach
    public void preparation() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
    }

    @Test
    public void shouldGetAll() {

        Tickets[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9};
        Tickets[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSort() {

        Tickets[] expected = {ticket7, ticket5, ticket6};
        Tickets[] actual = manager.searchBy("MSC", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNone() {

        Tickets[] expected = {};
        Tickets[] actual = manager.searchBy("SPB", "MSC");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOne() {

        Tickets[] expected = {ticket2};
        Tickets[] actual = manager.searchBy("LAX", "MSC");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemove() {

        repo.remove(5759989);

        Tickets[] expected = {ticket1, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9};
        Tickets[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortEquals() {

        Tickets[] expected = {ticket1, ticket8};
        Tickets[] actual = manager.searchBy("MSC", "DBX");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByTime() {

        Tickets[] expected = {ticket6, ticket7, ticket5};
        Tickets[] actual = manager.searchBy("MSC", "SPB", new TicketByTimeAscComparator());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByTimeEqual() {

        Tickets[] expected = {ticket2, ticket9};
        Tickets[] actual = manager.searchBy("LAX", "MSC", new TicketByTimeAscComparator());

        Assertions.assertArrayEquals(expected, actual);
    }
}
