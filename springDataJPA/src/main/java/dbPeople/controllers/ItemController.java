package dbPeople.controllers;

import dbPeople.models.Item;
import dbPeople.models.Person;
import dbPeople.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping
    public String index(Model model) {
        model.addAttribute("items", itemService.getAll());
        return "/items/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", itemService.getById(id));
        return "/items/show";
    }

    @GetMapping("/new")
    public String newItem(@ModelAttribute("item") Item item) {
        return "/items/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("item") @Valid Item item,
                         BindingResult bindingResult) {
        itemService.save(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("item", itemService.getById(id));
        return "/items/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("item") @Valid Item item, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "/items/edit";

        itemService.update(id, item);
        return "redirect:/items";
    }

    @PatchMapping("/deleteIdPerson/{id}")
    public String update(@ModelAttribute("person") Person person,
                         @PathVariable("id") int id) {
        itemService.deleteIdPerson(id);
        return "redirect:/people/" + person.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        itemService.deleteById(id);
        return "redirect:/items";
    }
}

