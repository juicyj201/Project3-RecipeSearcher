package za.ac.cput.recipesearcher.Repository;

import java.util.List;
import java.util.Optional;

import za.ac.cput.recipesearcher.Entities.User;

public interface UserRepository extends IRepository<User, String>{
    public User save(User user);
    public List<User> readAll();
    public Optional<User> update(User user);
}
