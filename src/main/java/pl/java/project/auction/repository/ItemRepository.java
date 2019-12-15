package pl.java.project.auction.repository;

import pl.java.project.auction.entities.Item;

public interface ItemRepository {
    Item addItems(Item item);

    Item getById(Long id);
}
