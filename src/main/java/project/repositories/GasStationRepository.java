package project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.GasStation;
@Repository
public interface GasStationRepository extends JpaRepository<GasStation, Integer> {
}
