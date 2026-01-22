package web.spring_boot.service;



import web.spring_boot.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> getAll();

    void update(Long id, User user);

    void delete(Long id);

    User getById(Long id);
}
