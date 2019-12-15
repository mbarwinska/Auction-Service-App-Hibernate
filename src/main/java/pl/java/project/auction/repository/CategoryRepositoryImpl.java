package pl.java.project.auction.repository;

import pl.java.project.auction.entities.Category;

import javax.persistence.EntityManager;
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
}
