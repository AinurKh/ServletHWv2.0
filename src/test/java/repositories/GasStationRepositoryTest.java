package repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import project.entity.GasStation;
import project.entity.Person;
import project.repositories.GasStationRepository;
import project.springConfig.JpaConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JpaConfig.class)
public class GasStationRepositoryTest {

    @Autowired
    private GasStationRepository gasStationRepository;

    @Test
    void testSaveAndFindCar() {
        GasStation gasStation = new GasStation();
        gasStation.setName("Tesla");
        gasStation.setNumber(22);
        gasStationRepository.save(gasStation);

        GasStation gasStation1 = gasStationRepository.findById( gasStation.getId()).orElse(null);
        assertNotNull(gasStation1);
        assertEquals(gasStation.getName(), gasStation1.getName());
        assertEquals(gasStation.getNumber(), gasStation1.getNumber());
    }

    @Test
    void findAll(){
        GasStation gasStation = new GasStation();
        gasStation.setName("Tesla");
        gasStation.setNumber(22);
        gasStationRepository.save(gasStation);

        List<GasStation> cars = gasStationRepository.findAll();

        assertNotNull(cars);
        assertEquals(cars.size(), 1);
    }

    @Test
    void delete(){
        GasStation gasStation = new GasStation();
        gasStation.setName("Tesla");
        gasStation.setNumber(22);
        gasStationRepository.save(gasStation);

        gasStationRepository.deleteById(gasStation.getId());
        GasStation deletedStation = gasStationRepository.findById(gasStation.getId()).orElse(null);

        assertNull(deletedStation,"Should be null");
    }

    @Test
    void update(){
        GasStation gasStation = new GasStation();
        gasStation.setName("Tesla");
        gasStation.setNumber(22);
        gasStationRepository.save(gasStation);

        GasStation gasStation1 = gasStationRepository.findById( gasStation.getId()).orElse(null);
        gasStation1.setName("VNW");
        gasStationRepository.save(gasStation1);

        GasStation result = gasStationRepository.findById(gasStation1.getId()).orElse(null);

        assertNotEquals(gasStation.getName(),result.getName());
    }
}
