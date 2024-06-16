package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.entity.Car;
import project.entity.GasStation;
import project.repositories.GasStationRepository;
import project.service.GasStationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class GasStationServiceTest {

    @InjectMocks
    private GasStationService gasStationService;
    @Mock
    private GasStationRepository gasStationRepository;

    @Test
    void findAll() {
        List<GasStation> gasStations = new ArrayList<>();
        gasStations.add(new GasStation());
        when(gasStationRepository.findAll()).thenReturn(gasStations);
        List<GasStation> gasStations1 = gasStationService.findAll();

        assertEquals(gasStations1.size(), gasStations.size());
    }

    @Test
    void findById() {
        GasStation gasStation = new GasStation();
        gasStation.setName("BMW");

        when(gasStationRepository.findById(1)).thenReturn(Optional.of(gasStation));
        GasStation gasStationServiceById = gasStationService.findById(1);

        assertEquals(gasStation.getId(), gasStationServiceById.getId());
    }

    @Test
    void save() {
        GasStation gasStation = new GasStation();
        gasStation.setName("BMW");

        gasStationService.save(gasStation);
        verify(gasStationRepository,times(1)).save(gasStation);
    }

    @Test
    void delete() {
        int id = 1;
        gasStationService.delete(id);
        verify(gasStationRepository,times(1)).deleteById(id);
    }

    @Test
    void update() {
        int id = 1;
        GasStation gasStation = new GasStation();
        gasStationService.update(gasStation,id);
        verify(gasStationRepository,times(1)).save(gasStation);

    }
}