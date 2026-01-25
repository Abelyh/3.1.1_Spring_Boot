package web.spring_boot.dao;



import web.spring_boot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    User create(User user);

    List<User> getAll();

    void update(User user);

    void delete(User user);

    Optional<User> getById(Long id);
}
