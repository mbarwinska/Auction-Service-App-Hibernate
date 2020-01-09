package pl.java.project.auction.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.java.project.auction.entities.Description;
import pl.java.project.auction.entities.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryImplTest {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORM");
    private EntityManager em;
    private ItemRepository itemRepository;
    private static Long id;

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        itemRepository = new ItemRepositoryImpl(em);
    }

    @AfterEach
    void cleanUp() {
        em.close();
    }

    @Test
    void addItem(){
        Item item = new Item(new Description("Comics"), BigDecimal.TEN);
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        Item result = itemRepository.addItem(item);
        transaction.commit();

        assertThat(result.getId()).isGreaterThan(0);

    }
}