package dbPeople.DAO;

import dbPeople.models.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.HashSet;
import java.util.List;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void getAllWithItem() {
        Session session = entityManager.unwrap(Session.class);
//        List<Person> people = session.createQuery("SELECT p FROM Person p", Person.class)
//                .getResultList();


        HashSet<Person> people = new HashSet<>(session.createQuery("SELECT p FROM Person p LEFT JOIN FETCH p.items", Person.class)
                .getResultList());
        for (Person person : people) {
            System.out.println("Person " + person.getName() + " has: " + person.getItems());
        }
    }
}
