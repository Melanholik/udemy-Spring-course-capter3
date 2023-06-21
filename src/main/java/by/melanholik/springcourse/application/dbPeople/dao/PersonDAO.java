package by.melanholik.springcourse.application.dbPeople.dao;

import by.melanholik.springcourse.application.dbPeople.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 15, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Ben", 34, "ben@amazon.by"));
        people.add(new Person(++PEOPLE_COUNT, "Kate", 20, "kate@onliner.by"));
        people.add(new Person(++PEOPLE_COUNT, "Ann", 18, "ann@mail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person currentPerson = people.stream().filter(person1 -> person1.getId() == id)
                .findAny().orElse(null);
        if (currentPerson != null) {
            currentPerson.setName(person.getName());
            currentPerson.setAge(person.getAge());
            currentPerson.setEmail(person.getEmail());
        }
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
