import entity.Permission;
import entity.Role;
import entity.User;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Role memberRole = new Role();
        memberRole.setName("member");

        Role adminRole = new Role();
        adminRole.setName("admin");

        Permission readPermission = new Permission();
        readPermission.setName("read");

        Permission writePermission = new Permission();
        writePermission.setName("write");

        Permission banPermission = new Permission();
        banPermission.setName("ban");

        Permission deletePermission = new Permission();
        deletePermission.setName("delete");

        List<Permission> memberPermissions = new ArrayList<Permission>();
        memberPermissions.add(readPermission);
        memberPermissions.add(writePermission);

        List<Permission> adminPermissions = new ArrayList<Permission>();
        adminPermissions.add(readPermission);
        adminPermissions.add(writePermission);
        adminPermissions.add(banPermission);
        adminPermissions.add(deletePermission);

        memberRole.setPermissions(memberPermissions);
        adminRole.setPermissions(adminPermissions);

        User user = new User();
        user.setName("John");
        user.setLogin("john");
        user.setPassword("123");
        user.setRole(memberRole);

        entityManager.persist(readPermission);
        entityManager.persist(writePermission);
        entityManager.persist(banPermission);
        entityManager.persist(deletePermission);

        entityManager.persist(memberRole);
        entityManager.persist(adminRole);

        entityManager.persist(user);


        entityManager.getTransaction().commit();

        entityManager.close();
        sessionFactory.close();
    }
}
