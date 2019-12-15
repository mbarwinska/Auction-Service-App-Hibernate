package pl.java.project.auction.repository;

import pl.java.project.auction.entities.Category;

import javax.persistence.EntityManager;

public class CategoryRepositoryImpl implements CategoryRepository {

    private EntityManager em;

    public CategoryRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Category createCategory(Category category) {
        return null;
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
