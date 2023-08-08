package by.melanholik.springcourse.hibernate;

import by.melanholik.springcourse.hibernate.model.Item;
import by.melanholik.springcourse.hibernate.model.Passport;
import by.melanholik.springcourse.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppOneToOne {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person = new Person("Vit2", 35);
            Passport passport = new Passport(person, 123456);
            person.addPassport(passport);
            session.persist(person);
            session.getTransaction().commit();
        }
    }
}

