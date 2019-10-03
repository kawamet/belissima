package karolina.model.DAO;

import karolina.model.User;

import java.io.Serializable;
import java.util.List;

public interface DaoInferface<T> {
    public void persist(T entity);

    public T findById(Long id);

    public List<T> findAll();

    //public void delete(T entity);
    //public void update(T entity);

}
