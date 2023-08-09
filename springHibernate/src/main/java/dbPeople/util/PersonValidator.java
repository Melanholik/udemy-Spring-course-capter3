package dbPeople.util;


import dbPeople.dao.PersonDAO;
import dbPeople.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personDAO.show(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "This email is already taken");
        }
    }

    public void validateWhenChange(Object target, Errors errors) {
        Person person = (Person) target;
        Optional<Person> person1 = personDAO.show(person.getEmail());
        if (person1.isPresent() && person1.get().getId() != person.getId()) {
            errors.rejectValue("email", "", "This email is already taken");
        }
    }
}
