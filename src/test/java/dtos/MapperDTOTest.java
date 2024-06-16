package dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.dtos.CarDTO;
import project.dtos.GasStationDTO;
import project.dtos.MapperDTO;
import project.dtos.PersonDTO;
import project.entity.Car;
import project.entity.GasStation;
import project.entity.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperDTOTest {
    MapperDTO mapperDTO;
    CarDTO carDTO;
    Car car;
    @BeforeEach
    void setUp() {
        carDTO = new CarDTO();
        car = new Car();
    }

    @Test
    void carToCarDTO() {
        car.setId(1);
        carDTO = MapperDTO.INSTANCE.carToCarDTO(car);

        assertEquals(carDTO.getId(), car.getId());
    }

    @Test
    void carDTOToCar() {
        carDTO.setId(1);
        car = MapperDTO.INSTANCE.carDTOToCar(carDTO);

        assertEquals(car.getId(), carDTO.getId());
    }

    @Test
    void personToPersonDTO() {
        Person person = new Person();
        person.setName("Ainur");
        PersonDTO personDTO = MapperDTO.INSTANCE.personToPersonDTO(person);

        assertEquals(personDTO.getName(), person.getName());
    }

    @Test
    void personDTOToPerson() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName("Ainur");
        Person person = MapperDTO.INSTANCE.personDTOToPerson(personDTO);

        assertEquals(person.getName(), personDTO.getName());
    }

    @Test
    void gasStationToGasStationDTO() {
        GasStation gasStation = new GasStation();
        gasStation.setId(1);
        GasStationDTO gasStationDTO = MapperDTO.INSTANCE.gasStationToGasStationDTO(gasStation);

        assertEquals(gasStationDTO.getId(), gasStation.getId());
    }

    @Test
    void gasStationDTOToGasStation() {
        GasStationDTO gasStationDTO = new GasStationDTO();
        gasStationDTO.setId(1);
        GasStation gasStation = MapperDTO.INSTANCE.gasStationDTOToGasStation(gasStationDTO);

        assertEquals(gasStation.getId(), gasStationDTO.getId());
    }
}