package dtos;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import project.dtos.CarDTO;
import project.dtos.GasStationDTO;
import project.dtos.PersonDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonDTOTest {
    private PersonDTO person;

    @Test
    @Order(1)
    void testSetGetIdTest(){
        int id = 1;
        person = new PersonDTO();
        person.setId(id);

        assertEquals(id, person.getId(),"id must match");
    }

    @Test
    @Order(2)
    void testSetGetName(){
        String name = "John Doe";
        person = new PersonDTO();
        person.setName(name);
        assertEquals(name, person.getName(),"name must match");
    }

    @Test
    @Order(3)
    void testSetGetAge(){
        int age = 20;
        person = new PersonDTO();
        person.setAge(age);

        assertEquals(age, person.getAge(),"age must match");
    }
    @Test
    @Order(4)
    void testSetGetCar(){
        person = new PersonDTO();
        CarDTO car = new CarDTO();
        person.setCarDTO(car);

        assertEquals(car, person.getCarDTO(),"car must match");
    }

    @Test
    @Order(5)
    void testSetGetList(){
        GasStationDTO gasStationBuilder = new GasStationDTO();
        gasStationBuilder.setName("TAIF");
        gasStationBuilder.setNumber(22);

        List<GasStationDTO> list = new ArrayList<>();
        list.add(gasStationBuilder);

        person = new PersonDTO();
        person.setGasStationDTOList(list);

        assertEquals(list,person.getGasStationDTOList(),"Could be same");
    }


    @Test
    @Order(6)
    void testToString(){
        person = new PersonDTO();
        person.setName("John Doe");
        person.setAge(20);

        String toString = ("PersonDTO{" +
                "age=" + person.getAge() +
                ", name='" + person.getName() + '\'' +
                ", id=" + person.getId() +
                '}');


        assertEquals(toString, person.toString(),"Must be the same");
    }
}
