package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.entity.GasStation;
import project.entity.Person;
import project.repositories.GasStationRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GasStationService {
    private GasStationRepository gasStationRepository;

    @Autowired
    public GasStationService(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    public List<GasStation> findAll(){
        return gasStationRepository.findAll();
    }

    public GasStation findById(int id){
        return gasStationRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(GasStation gasStation){
        gasStationRepository.save(gasStation);
    }

    @Transactional
    public void delete(int id){
        gasStationRepository.deleteById(id);
    }

    @Transactional
    public void update(GasStation gasStation, int id){
        gasStation.setId(id);
        gasStationRepository.save(gasStation);
    }
}
