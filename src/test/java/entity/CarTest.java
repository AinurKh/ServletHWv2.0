package entity;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import project.entity.Car;
import project.entity.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarTest {
    private Car car;

    @Test
    @Order(1)
    void testSetGetId(){
        int id = 1;
        car = new Car();
        car.setId(id);

        assertEquals(id, car.getId());
    }
    @Test
    @Order(2)
    void testSetGetPersonId(){
        Person person = new Person();
        car = new Car();
        car.setPerson(person);

        assertEquals(person, car.getPerson());
    }

    @Test
    @Order(3)
    void testSetGetModel(){
        String model = "BMW";
        car = new Car();
        car.setModel(model);

        assertEquals(model, car.getModel());
    }

    @Test
    @Order(4)
    void testSetGetHorsePower(){
        int horsePower = 100;
        car = new Car();
        car.setHorsePower(horsePower);

        assertEquals(horsePower, car.getHorsePower());
    }

    @Test
    @Order(5)
    void testToString(){
        car = new Car();
        car.setModel("AUDI");
        car.setHorsePower(330);



        String toString = ("Car{" +
                "id=" + car.getId() +
                ", person=" + car.getPerson() +
                ", model='" + car.getModel() + '\'' +
                ", horsePower=" + car.getHorsePower() +
                '}');

        assertEquals(toString, car.toString(),"Must be the same");
    }
}
