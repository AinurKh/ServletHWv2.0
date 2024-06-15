package project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
