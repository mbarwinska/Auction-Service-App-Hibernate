package pl.java.project.auction.repository;

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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ItemRepositoryImplTest {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORM");
    private EntityManager em;
    private static Long id;
    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        itemRepository = new ItemRepositoryImpl(em);
        categoryRepository = new CategoryRepositoryImpl(em);
    }

    @AfterEach
    void cleanUp() {
        em.close();
    }

    @Order(1)
    @Test
    void createNewCategoryForTest() {
        final EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        Category category = new Category("Fake category");
        categoryRepository.createCategory(category);
        transaction.commit();

        id = category.getId();

        assertThat(category.getId()).isGreaterThan(0);
    }

    @Order(2)
    @Test
    void addItem() {
        final EntityTransaction transaction = em.getTransaction();
        final Category reference = em.getReference(Category.class, id);
        final Item item = new Item(reference, new Description("foo"), BigDecimal.TEN);

        transaction.begin();
        itemRepository.addItems(item);
        transaction.commit();

        assertThat(item.getId()).isGreaterThan(0);
    }


}