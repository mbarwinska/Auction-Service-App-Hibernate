package pl.java.project.auction.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.java.project.auction.entities.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryRepositoryImplTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORM");
    private EntityManager em;

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
    }

    @AfterEach
    void cleanUp() {
        em.close();
    }

    @Test
    void addToRepository() {
        CategoryRepository categoryRepository = new CategoryRepositoryImpl(em);
        Category category = new Category("Book");
        final EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        final Category result = categoryRepository.createCategory(category);
        transaction.commit();

        assertThat(result.getId()).isGreaterThan(0);
    }
}