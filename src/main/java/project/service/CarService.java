package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.entity.Car;
import project.entity.Person;
import project.repositories.CarRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll(){
       return carRepository.findAll();
    }

    public Car findById(int id){
       return carRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Car car){
        carRepository.save(car);
    }

    @Transactional
    public void delete(int id){
        carRepository.deleteById(id);
    }

    @Transactional
    public void update(Car car, int id){
        car.setId(id);
        carRepository.save(car);
    }
}
