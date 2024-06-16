package entity;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import project.entity.GasStation;
import project.entity.Person;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GasStationTest {
    private GasStation gasStation;

    @Test
    @Order(1)
    void testSetGetId(){
        int id = 1;
        gasStation = new GasStation();
        gasStation.setId(id);

        assertEquals(id, gasStation.getId());
    }

    @Test
    @Order(2)
    void testSetGetName(){
        String name = "AINUR";
        gasStation = new GasStation();
        gasStation.setName(name);

        assertEquals(name, gasStation.getName());
    }

    @Test
    @Order(3)
    void testSetGetNumber(){
        int number = 1;
        gasStation = new GasStation();
        gasStation.setNumber(number);


        assertEquals(number, gasStation.getNumber());
    }

    @Test
    @Order(4)
    void testSetGetPeople(){
        List<Person> list = new ArrayList<>();

        gasStation = new GasStation();
        gasStation.setPersonList(list);

        assertEquals(list, gasStation.getPersonList());
    }

    @Test
    @Order(5)
    void testToString(){
        gasStation = new GasStation();
        gasStation.setName("Ainur");


        String toString = ("GasStation{" +
            "id=" + gasStation.getId() +
                    ", name='" + gasStation.getName() + '\'' +
                    ", number=" + gasStation.getNumber() +
                    '}');

        assertEquals(toString, gasStation.toString(),"Must be the same");
    }
}
