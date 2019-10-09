package karolina.model.DAO;

import java.util.List;

public interface DaoInferface<T> {
    void persist(T entity);

    T findById(Long id);

    List<T> findAll();

    //public void delete(T entity);
    //public void update(T entity);

}
