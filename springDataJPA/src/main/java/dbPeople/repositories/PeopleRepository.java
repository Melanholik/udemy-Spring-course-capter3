package dbPeople.repositories;

import dbPeople.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

    public List<Person> findByEmail(String email);
}
