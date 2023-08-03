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
            session.persist(new Person("Vera", 37));
            session.persist(new Person("Ola", 30));
            session.persist(new Person("Sergey", 34));
            session.getTransaction().commit();
        }
    }
}
