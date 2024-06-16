package dtos;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import project.dtos.GasStationDTO;
import project.dtos.PersonDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GasStationDTOTest {
    private GasStationDTO gasStation;

    @Test
    @Order(1)
    void testSetGetId(){
        int id = 1;
        gasStation = new GasStationDTO();
        gasStation.setId(id);

        assertEquals(id, gasStation.getId());
    }

    @Test
    @Order(2)
    void testSetGetName(){
        String name = "AINUR";
        gasStation = new GasStationDTO();
        gasStation.setName(name);

        assertEquals(name, gasStation.getName());
    }

    @Test
    @Order(3)
    void testSetGetNumber(){
        int number = 1;
        gasStation = new GasStationDTO();
        gasStation.setNumber(number);


        assertEquals(number, gasStation.getNumber());
    }

    @Test
    @Order(4)
    void testSetGetPeople(){
        List<PersonDTO> list = new ArrayList<>();

        gasStation = new GasStationDTO();
        gasStation.setPersonDTOList(list);

        assertEquals(list, gasStation.getPersonDTOList());
    }

    @Test
    @Order(5)
    void testToString(){
        gasStation = new GasStationDTO();
        gasStation.setName("Ainur");


        String toString = ("GasStationDTO{" +
                "id=" + gasStation.getId() +
                ", name='" + gasStation.getName() + '\'' +
                ", number=" + gasStation.getNumber() +
                '}');

        assertEquals(toString, gasStation.toString(),"Must be the same");
    }
}
