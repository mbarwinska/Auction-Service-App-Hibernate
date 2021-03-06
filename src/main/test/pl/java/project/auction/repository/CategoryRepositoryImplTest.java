package pl.java.project.auction.repository;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.*;
import pl.java.project.auction.entities.Category;
import pl.java.project.auction.entities.Description;
import pl.java.project.auction.entities.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryRepositoryImplTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORM");
    private EntityManager em;
    private CategoryRepository categoryRepository;
    private static Long id;

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        categoryRepository = new CategoryRepositoryImpl(em);
    }

    @AfterEach
    void cleanUp() {
        em.close();
    }

    @Order(1)
    @Test
    void addToRepository() {
        Category category = new Category("Book");
        final EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        final Category result = categoryRepository.createCategory(category);
        transaction.commit();

        id = result.getId();
        assertThat(result.getId()).isGreaterThan(0);
    }

    @Order(2)
    @Test
    void readCategory() {
        final EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        final Category result = categoryRepository.readCategoryById(id);

        transaction.commit();
        assertThat(result).isNotNull();

    }

    @Order(3)
    @Test
    void updateCategory() {
        final EntityTransaction transaction = em.getTransaction();
        final String newValueOfName = "Ksiazki";


        transaction.begin();
        final Category valueFromDatabase = categoryRepository.readCategoryById(id);
        transaction.commit();
        em.close();
//        Zamknięcie pierwsze EntityManager i przejście obiektu w stan odłączony


        valueFromDatabase.modifyName(newValueOfName);


        em = emf.createEntityManager();
        categoryRepository = new CategoryRepositoryImpl(em);
        final EntityTransaction secondTransaction = em.getTransaction();

//       Utrwalenie obiektu który jest w stanie odłączony
        secondTransaction.begin();
        categoryRepository.updateCategory(valueFromDatabase);
        final Category updatedCategory = categoryRepository.readCategoryById(id);
        secondTransaction.commit();

        assertThat(updatedCategory.getName()).isEqualTo(newValueOfName);
    }

    @Order(5)
    @Test
    void throwLazyInitializationException() {
        final EntityTransaction transaction = em.getTransaction();
        Item item = new Item(new Description("Opis"), BigDecimal.TEN);

        transaction.begin();
        final Category valueFromDatabate = categoryRepository.readCategoryById(id);
        transaction.commit();
        em.close();


        assertThatExceptionOfType(LazyInitializationException.class).isThrownBy(
                () -> valueFromDatabate.getItems().add(item)
        );
    }

    @Order(6)
    @Test
    void notThrowLazyInitializationException() {
        final EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        final Category valueFromDatabate = categoryRepository.readCategoryWithItemsList(id);
        transaction.commit();
        em.close();

        assertThat(valueFromDatabate.getItems().isEmpty()).isTrue();

    }


    @Order(10)
    @Test
    void deleteCategory() {
        final EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        final Category valueFromDatabate = categoryRepository.readCategoryById(id);
        categoryRepository.deleteCategory(valueFromDatabate);
        transaction.commit();
        final Category shouldBeNull = categoryRepository.readCategoryById(id);
        assertThat(shouldBeNull).isNull();
    }


}