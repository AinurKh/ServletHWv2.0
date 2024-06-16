package dtos;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import project.dtos.CarDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarDTOTest {
    private CarDTO car;

    @Test
    @Order(1)
    void testSetGetId(){
        int id = 1;
        car = new CarDTO();
        car.setId(id);

        assertEquals(id, car.getId());
    }
    @Test
    @Order(2)
    void testSetGetPersonId(){
        Long id = 2L;
        car = new CarDTO();
        car.setPersonId(id);

        assertEquals(id, car.getPersonId());
    }

    @Test
    @Order(3)
    void testSetGetModel(){
        String model = "BMW";
        car = new CarDTO();
        car.setModel(model);

        assertEquals(model, car.getModel());
    }

    @Test
    @Order(4)
    void testSetGetHorsePower(){
        int horsePower = 100;
        car = new CarDTO();
        car.setHorsePower(horsePower);

        assertEquals(horsePower, car.getHorsePower());
    }

    @Test
    @Order(5)
    void testToString(){
        car = new CarDTO();
        car.setModel("AUDI");
        car.setHorsePower(330);



        String toString = ("CarDTO{" +
                "id=" + car.getId() +
                ", personId=" + car.getPersonId() +
                ", model='" + car.getModel() + '\'' +
                ", horsePower=" + car.getHorsePower() +
                '}');

        assertEquals(toString, car.toString(),"Must be the same");
    }
}
