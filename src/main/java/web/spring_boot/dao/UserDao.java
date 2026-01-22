package web.spring_boot.dao;



import web.spring_boot.model.User;

import java.util.List;

public interface UserDao {

    User create(User user);

    List<User> getAll();

    void update(User user);

    void delete(User user);

    User getById(Long id);
}
