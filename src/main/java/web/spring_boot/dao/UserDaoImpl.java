package web.spring_boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import web.spring_boot.model.User;


import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public User create(User user) {
        manager.persist(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return manager.createQuery("From User", User.class).getResultList();
    }


    @Override
    public Optional<User> getById(Long id) {
        return Optional.ofNullable(manager.find(User.class, id));
    }

    @Override
    public void update(User userById) {
        manager.merge(userById);
    }

    @Override
    public void delete(User user) {
        manager.remove(user);
    }

}
