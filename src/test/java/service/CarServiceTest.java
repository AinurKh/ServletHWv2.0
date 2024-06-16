package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.C;
import project.dtos.CarDTO;
import project.dtos.PersonDTO;
import project.entity.Car;
import project.entity.Person;
import project.repositories.CarRepository;
import project.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @InjectMocks
    private CarService carService;
    @Mock
    private CarRepository carRepository;

    @Test
    void findAll() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        when(carRepository.findAll()).thenReturn(cars);
        List<Car> cars1 = carService.findAll();

        assertEquals(cars1.size(), cars.size());
    }

    @Test
    void findById() {
        Car car = new Car();
        car.setModel("BMW");

        when(carRepository.findById(1)).thenReturn(Optional.of(car));
        Car car1 = carService.findById(1);

        assertEquals(car.getId(), car1.getId());
    }

    @Test
    void save() {
        Car car = new Car();
        car.setModel("Oleg");

        carService.save(car);
        verify(carRepository,times(1)).save(car);
    }

    @Test
    void delete() {
        int id = 1;
        carService.delete(id);
        verify(carRepository,times(1)).deleteById(id);
    }

    @Test
    void update() {
        int id = 1;
        Car car = new Car();
        carService.update(car,id);
        verify(carRepository,times(1)).save(car);

    }

    @Test
    void getDTOList() {
        Car car = new Car();
        List<Car> carList = new ArrayList<>();
        carList.add(car);

        when(carRepository.findAllWithPerson()).thenReturn(carList);

        List<CarDTO> list = carService.getDTOList();
        assertEquals(list.size(), carList.size());
    }

    @Test
    void saveDTO() {
        CarDTO carDTO = new CarDTO();
        carDTO.setModel("Oleg");
        carService.saveDTO(carDTO);

        verify(carRepository,times(1)).save(any(Car.class));
    }

    @Test
    void updateDTO() {
        CarDTO carDTO = new CarDTO();
        int id = 1;
        carService.updateDTO(carDTO,id);
        verify(carRepository,times(1)).save(any(Car.class));
    }
}