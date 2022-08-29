package za.ac.cput.recipesearcher.Repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, ID> {
    public T save(T entity);
    public T read(T entity);
    public List<T> readAll();
}
