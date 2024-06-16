package repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import project.entity.Car;
import project.entity.Person;
import project.repositories.CarRepository;
import project.springConfig.JpaConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JpaConfig.class)
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
     void testSaveAndFindCar() {
        Car car = new Car();
        car.setModel("Tesla");
        car.setHorsePower(500);
        carRepository.save(car);

        Car foundCar = carRepository.findById(car.getId()).orElse(null);
        assertNotNull(foundCar);
        assertEquals(car.getModel(), foundCar.getModel());
        assertEquals(car.getHorsePower(), foundCar.getHorsePower());
    }

    @Test
     void findAll(){
        Car car = new Car();
        car.setModel("Tesla");
        car.setHorsePower(500);
        carRepository.save(car);
        List<Car> cars = carRepository.findAll();

        assertNotNull(cars);
        assertEquals(cars.size(), 1);
    }

    @Test
     void delete(){
        Car car = new Car();
        car.setModel("Tesla");
        car.setHorsePower(500);

        carRepository.save(car);
        carRepository.deleteById(car.getId());
        Car deletedCar = carRepository.findById(car.getId()).orElse(null);

        assertNull(deletedCar,"Should be null");
    }

    @Test
     void update(){
        Car car = new Car();
        car.setModel("Tesla");
        car.setHorsePower(500);

        carRepository.save(car);

        Car foundCar = carRepository.findById(car.getId()).orElse(null);
        foundCar.setModel("VNW");
        carRepository.save(foundCar);

        Car result = carRepository.findById(foundCar.getId()).orElse(null);

        assertNotEquals(car.getModel(),foundCar.getModel());
    }

    @Test
    void findAllWithPerson(){
        List<Car> cars = carRepository.findAllWithPerson();
        List<Person> personList = new ArrayList<>();
        for (Car car : cars) {
            personList.add(car.getPerson());
        }

        assertNotNull(personList);
    }
}