package by.melanholik.springcourse.hibernate;

import by.melanholik.springcourse.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person = new Person("Kirill", 28);
            session.persist(person);
            System.out.println(person.getId());
            person.setName("Vitaliy");
            Person person1 = session.get(Person.class, 5);
            session.remove(person1);
            session.getTransaction().commit();
            System.out.println(person.getId());
        }
    }
}
