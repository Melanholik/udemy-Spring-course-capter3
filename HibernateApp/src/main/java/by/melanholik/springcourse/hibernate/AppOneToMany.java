package by.melanholik.springcourse.hibernate;

import by.melanholik.springcourse.hibernate.model.Item;
import by.melanholik.springcourse.hibernate.model.Passport;
import by.melanholik.springcourse.hibernate.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppOneToMany {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            System.out.println(person);
            Hibernate.initialize(person.getItems());
            session.getTransaction().commit();
            System.out.println(person.getItems());
        }
    }
}
