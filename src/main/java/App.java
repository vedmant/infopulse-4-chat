import entity.User;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

//        User u1 = new User();
//        u1.setName("John");
//        u1.setLogin("john");
//
//        User u2 = new User();
//        u2.setName("Daenerys");
//        u2.setLogin("daenerys");
//
//        entityManager.persist(u1);
//        entityManager.persist(u2);
        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();
    }
}
