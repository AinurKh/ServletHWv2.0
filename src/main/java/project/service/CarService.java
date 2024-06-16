package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dtos.CarDTO;
import project.dtos.MapperDTO;
import project.entity.Car;

import project.repositories.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<CarDTO> getDTOList(){
        List<Car> cars = carRepository.findAllWithPerson();
        List<CarDTO> carDTOS = cars.stream()
                .map(MapperDTO.INSTANCE::carToCarDTO)
                .collect(Collectors.toList());

        return carDTOS;
    }

    @Transactional
    public void saveDTO(CarDTO carDTO){
        save(MapperDTO.INSTANCE.carDTOToCar(carDTO));
    }

    @Transactional
    public void updateDTO(CarDTO carDTO, int id){
        update(MapperDTO.INSTANCE.carDTOToCar(carDTO), id);
    }


}
