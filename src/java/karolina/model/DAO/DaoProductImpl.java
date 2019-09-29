package karolina.model.DAO;

import karolina.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DaoProductImpl implements DaoInferface<Product> {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("manager1");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public void persist(Product entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        closeAll(entityManager,entityManagerFactory);
    }

    @Override
    public Product findById(Long id) {
        entityManager.getTransaction().begin();
        Product product = entityManager.getReference(Product.class, id);
        entityManager.getTransaction().commit();
        return product;
    }

    @Override
    public List<Product> findAll() {
        entityManager.getTransaction().begin();
        Query fromUser = entityManager.createQuery("FROM Product");
        entityManager.getTransaction().commit();
        return fromUser.getResultList();

    }

    public void closeAll(EntityManager entityManager, EntityManagerFactory entityManagerFactory){
        entityManager.close();
        entityManager.close();
    }
}
