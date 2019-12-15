package pl.java.project.auction.repository;

import org.hibernate.Hibernate;
import pl.java.project.auction.entities.Category;
import pl.java.project.auction.entities.Item;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class CategoryRepositoryImpl implements CategoryRepository {

    private EntityManager em;

    public CategoryRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Category createCategory(Category category) {
        if (Objects.isNull(category.getId())) {
            em.persist(category);
        }
        return category;
    }

    @Override
    public Category readCategoryById(Long id) {
        final Category category = em.find(Category.class, id);
        return category;
    }

    @Override
    public void updateCategory(Category category) {
        em.merge(category);
    }

    @Override
    public void deleteCategory(Category category) {
        em.remove(category);
    }

    @Override
    public Category readCategoryWithItemsList(Long id) {
        final Category category = readCategoryById(id);
        final List<Item> items = category.getItems();
        Hibernate.initialize(items);
        return category;
    }
}
