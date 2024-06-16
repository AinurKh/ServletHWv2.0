package entity;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import project.entity.Car;
import project.entity.GasStation;
import project.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonTest {
    private Person person;

    @Test
    @Order(1)
    void testSetGetIdTest(){
        int id = 1;
        person = new Person();
        person.setId(id);

        assertEquals(id, person.getId(),"id must match");
    }

    @Test
    @Order(2)
    void testSetGetName(){
        String name = "John Doe";
        person = new Person();
        person.setName(name);
        assertEquals(name, person.getName(),"name must match");
    }

    @Test
    @Order(3)
    void testSetGetAge(){
        int age = 20;
        person = new Person();
        person.setAge(age);

        assertEquals(age, person.getAge(),"age must match");
    }
    @Test
    @Order(4)
    void testSetGetCar(){
        person = new Person();
        Car car = new Car();
        person.setCar(car);

        assertEquals(car, person.getCar(),"car must match");
    }

    @Test
    @Order(5)
    void testSetGetList(){
        GasStation gasStationBuilder = new GasStation();
        gasStationBuilder.setName("TAIF");
        gasStationBuilder.setNumber(22);

        List<GasStation> list = new ArrayList<>();
        list.add(gasStationBuilder);

        person = new Person();
        person.setStationList(list);

        assertEquals(list,person.getStationList(),"Could be same");
    }


    @Test
    @Order(6)
    void testToString(){
       person = new Person();
       person.setName("John Doe");
       person.setAge(20);

        String toString = ("Person{" +
                "age=" + person.getAge() +
                ", name='" + person.getName() + '\'' +
                ", id=" + person.getId() +
                '}');


        assertEquals(toString, person.toString(),"Must be the same");
    }
}
