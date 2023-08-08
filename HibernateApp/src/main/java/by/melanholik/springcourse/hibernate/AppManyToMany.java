package by.melanholik.springcourse.hibernate;

import by.melanholik.springcourse.hibernate.model.Actor;
import by.melanholik.springcourse.hibernate.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppManyToMany {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//            Actor actor = new Actor("Vitaliy", 35);
//            Actor actor2 = new Actor("Sergey", 34);
//            Movie movie = new Movie("Film 1", 2020);
//            Movie movie2 = new Movie("Film 2", 2023);
//            movie.setList(new ArrayList<>(List.of(actor, actor2)));
//            movie2.setList(new ArrayList<>(Collections.singleton(actor)));
//            actor.setMovies(new ArrayList<>(List.of(movie, movie2)));
//            actor2.setMovies(new ArrayList<>(Collections.singleton(movie)));
//            session.persist(actor);
//            session.persist(actor2);
//            session.persist(movie);
//            session.persist(movie2);

            Actor actor3 = new Actor("Vera", 37);
            Movie movie3 = new Movie("film 3", 2023);
            actor3.setMovies(new ArrayList<>(Collections.singleton(movie3)));
            session.persist(movie3);
            session.getTransaction().commit();
        }
    }
}
