package dbPeople.services;

import dbPeople.models.Item;
import dbPeople.models.Person;
import dbPeople.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }


    public Item getById(int id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Transactional
    public void update(int id, Item person) {
        person.setId(id);
        itemRepository.save(person);
    }

    @Transactional
    public void save(Item person) {
        itemRepository.save(person);
    }

    @Transactional
    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }

    @Transactional
    public void deleteIdPerson(int id){
        Optional<Item> item = itemRepository.findById(id);
        item.ifPresent(value -> value.setPerson(null));
    }
}
