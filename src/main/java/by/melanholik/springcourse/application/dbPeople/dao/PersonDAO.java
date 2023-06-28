package by.melanholik.springcourse.application.dbPeople.dao;

import by.melanholik.springcourse.application.dbPeople.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 4;
    private static final String URL = "jdbc:postgresql://localhost/first_DB";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    private static Connection connection;

    public PersonDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO person VALUES(" + ++PEOPLE_COUNT + ", '" + person.getName() + "', "
                    + person.getAge() + ", '" + person.getEmail() + "')";
            statement.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person person) {
//        Person currentPerson = people.stream().filter(person1 -> person1.getId() == id)
//                .findAny().orElse(null);
//        if (currentPerson != null) {
//            currentPerson.setName(person.getName());
//            currentPerson.setAge(person.getAge());
//            currentPerson.setEmail(person.getEmail());
//        }
    }

    public void delete(int id) {
//        people.removeIf(person -> person.getId() == id);
    }
}
