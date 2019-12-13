package pl.java.project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORM");

        EntityManager entityManager = emf.createEntityManager();

//        Session session = entityManager.unwrap( Session.class );


        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();


        transaction.commit();


//        entityManager.getTransaction().begin();

//        session.beginTransaction();


//        entityManager.getTransaction().commit();


//        session.close();


    }
}
