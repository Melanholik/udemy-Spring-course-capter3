package by.melanholik.springcourse.application.dbPeople.controllers;

import by.melanholik.springcourse.application.dbPeople.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("people" , people.index());
        return "/people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("person", people.show(id));
        return "/people/show";
    }
}
