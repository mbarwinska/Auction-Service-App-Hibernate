package pl.java.project.auction.repository;

import pl.java.project.auction.entities.Category;

public interface CategoryRepository {

    Category createCategory(Category category);

    Category readCategoryById(Long id);

    Category updateCategory(Category category);

    void deleteCategory(Category category);
}
