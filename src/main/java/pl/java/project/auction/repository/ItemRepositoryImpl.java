package pl.java.project.auction.repository;

import pl.java.project.auction.entities.Item;

import javax.persistence.EntityManager;
import java.util.Objects;

public class ItemRepositoryImpl implements ItemRepository {
    private EntityManager em;

    public ItemRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Item addItems(Item item) {
        if (Objects.isNull(item.getId())) {
            em.persist(item);
        }
        return item;
    }

    @Override
    public Item getById(Long id) {
        final Item item = em.find(Item.class, id);
        return item;
    }
}
