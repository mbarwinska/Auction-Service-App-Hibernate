package pl.java.project.auction.repository;

import pl.java.project.auction.entities.Item;

public interface ItemRepository {

    Item addItem (Item item);
    Item getById(Long id);

}
