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
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategory(Category category) {

    }
}
