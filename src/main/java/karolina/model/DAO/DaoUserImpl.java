package karolina.model.DAO;

import karolina.model.Product;
import karolina.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DaoUserImpl implements DaoInferface<User> {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("manager1");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void persist(User entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        closeAll(entityManager,entityManagerFactory);
    }

    public void merge(User entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        closeAll(entityManager,entityManagerFactory);
    }



    @Override
    public User findById(Long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.getReference(User.class, id);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> findAll() {
        entityManager.getTransaction().begin();
        Query fromUser = entityManager.createQuery("FROM User");
        entityManager.getTransaction().commit();
        return fromUser.getResultList();

    }

    private void closeAll(EntityManager entityManager, EntityManagerFactory entityManagerFactory){
        entityManager.close();
        entityManager.close();
    }


}
