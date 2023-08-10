package dbPeople.services;

import dbPeople.models.Person;
import dbPeople.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> getAll() {
        return peopleRepository.findAll();
    }


    public Person getById(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    public void update(int id, Person person) {
        person.setId(id);
        peopleRepository.save(person);
    }

    public void save(Person person) {
        peopleRepository.save(person);
    }

    public void deleteById(int id) {
        peopleRepository.deleteById(id);
    }
}
