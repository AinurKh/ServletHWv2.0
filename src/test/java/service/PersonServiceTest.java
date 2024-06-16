package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.dtos.PersonDTO;
import project.entity.Car;
import project.entity.Person;
import project.repositories.PeopleRepository;
import project.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;
    @Mock
    private PeopleRepository personRepository;

    @Test
    void findAll() {
        List<Person> people = new ArrayList<>();
        people.add(new Person());
        when(personRepository.findAll()).thenReturn(people);
        List<Person> persons = personService.findAll();

        assertEquals(people.size(), persons.size());
    }

    @Test
    void findById() {
        Person person = new Person();
        person.setId(1);
        person.setStationList(new ArrayList<>());
        person.setCar(new Car());

        when(personRepository.findById(1)).thenReturn(Optional.of(person));
        Person person1 = personService.findById(1);

        assertEquals(person.getId(), person1.getId());
    }

    @Test
    void save() {
        Person person = new Person();
        person.setName("Oleg");

        personService.save(person);
        verify(personRepository,times(1)).save(person);
    }

    @Test
    void delete() {
        int id = 1;
        personService.delete(id);
        verify(personRepository,times(1)).deleteById(id);
    }

    @Test
    void update() {
        int id = 1;
        Person person = new Person();
        personService.update(person,id);
        verify(personRepository,times(1)).save(person);

    }

    @Test
    void getDTOList() {
        Person person = new Person();
        List<Person> people = new ArrayList<>();
        people.add(person);

        when(personRepository.findAll()).thenReturn(people);

        List<PersonDTO> list = personService.getDTOList();
        assertEquals(list.size(), people.size());
    }

    @Test
    void saveDTO() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName("Oleg");
        personService.saveDTO(personDTO);

        verify(personRepository,times(1)).save(any(Person.class));
    }

    @Test
    void updateDTO() {
        PersonDTO personDTO = new PersonDTO();
        int id = 1;
        personService.updateDTO(personDTO,id);
        verify(personRepository,times(1)).save(any(Person.class));
    }
}