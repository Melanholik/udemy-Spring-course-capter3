package by.melanholik.springcourse.hibernate;

import by.melanholik.springcourse.hibernate.model.Item;
import by.melanholik.springcourse.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//            for (Item item : items) {
//                System.out.println(item);
//            }

//            Item item = session.get(Item.class, 3);
//            System.out.println(item);
//            System.out.println(item.getOwner());

//            Person person = session.get(Person.class, 1);
//            Item item = new Item("Marker", person);
//            person.getItems().add(item);
//            session.persist(item);

//            Person newPerson = new Person("Vit", 35);
//            Item newItem = new Item("Xbox", newPerson);
//            newPerson.setItems(new ArrayList<>(Collections.singletonList(newItem)));
//            session.persist(newPerson);
//            session.persist(newItem);

//            Person person = session.get(Person.class, 3);
//            List<Item> items = person.getItems();
//            for (Item item : items) {
//                session.remove(item);
//            }
//            person.getItems().clear();

//            Person person = session.get(Person.class, 2);
//            session.remove(person);
//            person.getItems().forEach(item -> item.setOwner(null));

            Person person = session.get(Person.class , 1);
            Person person2 = session.get(Person.class , 4);

            List<Item> items = person.getItems();
            items.forEach(item -> item.setOwner(person2));
            person2.getItems().addAll(items);
            items.clear();

            session.getTransaction().commit();
        }
    }
}

