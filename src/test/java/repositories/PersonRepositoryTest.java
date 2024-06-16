package repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import project.entity.Car;
import project.entity.Person;
import project.repositories.PeopleRepository;
import project.springConfig.JpaConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JpaConfig.class)
public class PersonRepositoryTest {

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    void testSaveAndFindCar() {
        Person person = new Person();
        person.setName("Tesla");
        person.setAge(22);
        peopleRepository.save(person);

        Person person1 = peopleRepository.findById( person.getId()).orElse(null);
        assertNotNull(person1);
        assertEquals(person.getName(), person1.getName());
        assertEquals(person.getAge(), person1.getAge());
    }

    @Test
    void findAll(){
        Person person = new Person();
        person.setName("Tesla");
        person.setAge(22);
        peopleRepository.save(person);
        List<Person> cars = peopleRepository.findAll();

        assertNotNull(cars);
        assertEquals(cars.size(), 1);
    }

    @Test
    void delete(){
        Person person = new Person();
        person.setName("Tesla");
        person.setAge(22);
        peopleRepository.save(person);

        peopleRepository.deleteById(person.getId());
        Person deletedPerson = peopleRepository.findById(person.getId()).orElse(null);

        assertNull(deletedPerson,"Should be null");
    }

    @Test
    void update(){
        Person person = new Person();
        person.setName("Tesla");
        person.setAge(22);
        peopleRepository.save(person);

        Person foundPerson = peopleRepository.findById(person.getId()).orElse(null);
        foundPerson.setName("VNW");
        peopleRepository.save(foundPerson);

        Person result = peopleRepository.findById(foundPerson.getId()).orElse(null);

        assertNotEquals(person.getName(),foundPerson.getName());
    }

}
