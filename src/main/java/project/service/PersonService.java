package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dtos.MapperDTO;
import project.dtos.PersonDTO;
import project.entity.Person;
import project.repositories.PeopleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }


    public Person findById(int id){
        return peopleRepository.findById(1).orElse(null);
    }

    @Transactional
    public int save(Person person){
        peopleRepository.save(person);
        return person.getId();
    }

    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }

    @Transactional
    public void update(Person person, int id){
        person.setId(id);
        peopleRepository.save(person);
    }

    public List<PersonDTO> getDTOList(){
        return peopleRepository.findAll()
                .stream()
                .map(MapperDTO.INSTANCE::personToPersonDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveDTO(PersonDTO personDTO){
       save(MapperDTO.INSTANCE.personDTOToPerson(personDTO));
    }

    @Transactional
    public void updateDTO(PersonDTO personDTO, int id){
        update(MapperDTO.INSTANCE.personDTOToPerson(personDTO), id);
    }

}
