package by.melanholik.springcourse.application.dbPeople.controllers;

import by.melanholik.springcourse.application.dbPeople.dao.PersonDAO;
import by.melanholik.springcourse.application.dbPeople.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO people;

    @Autowired
    public PeopleController(PersonDAO people) {
        this.people = people;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", people.index());
        return "/people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("person", people.show(id));
        return "/people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        people.save(person);
        return "redirect:/people";
    }
}
