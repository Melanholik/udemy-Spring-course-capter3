package by.melanholik.springcourse.hibernate;

import by.melanholik.springcourse.hibernate.model.Item;
import by.melanholik.springcourse.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person = new Person("Sergey2", 34);
            Item item = new Item("New Item");
            person.addItem(item);
            session.persist(person);
            session.getTransaction().commit();
        }
    }
}

