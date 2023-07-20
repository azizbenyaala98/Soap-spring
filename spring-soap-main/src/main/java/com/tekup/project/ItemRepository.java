package com.tekup.project;
import java.util.HashMap;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
@Component
public class ItemRepository {
    private static final Map<String, Item> items = new HashMap<>();
    @PostConstruct
    public void initData() {
        Item item1 = new Item();
        item1.setName("Book");
        item1.setDescription("A book for learning.");
        item1.setPrice(25);
        items.put(item1.getName(), item1);

        Item item2 = new Item();
        item2.setName("Pen");
        item2.setDescription("A pen for writing.");
        item2.setPrice(5);
        items.put(item2.getName(), item2);

        Item item3 = new Item();
        item3.setName("Notebook");
        item3.setDescription("A notebook for taking notes.");
        item3.setPrice(10);
        items.put(item3.getName(), item3);
    }

    public Item findItem(String name) {
        Assert.notNull(name, "Item name must not be null");
        return items.get(name);
    }

    public void createItem(Item item) {
        Assert.notNull(item, "Item must not be null");
        Assert.hasText(item.getName(), "Item name must not be empty");
        items.put(item.getName(), item);
    }


    public void updateItem(String name, Item updatedItem) {
        Assert.notNull(name, "Item name must not be null");
        Assert.notNull(updatedItem, "Updated item must not be null");
        Assert.hasText(updatedItem.getName(), "Updated item name must not be empty");
        items.put(name, updatedItem);
    }

    public void deleteItem(String name) {
        Assert.notNull(name, "Item name must not be null");
        items.remove(name);
    }
}
