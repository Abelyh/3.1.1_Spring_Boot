package web.spring_boot.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.spring_boot.dao.UserDao;
import web.spring_boot.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public void update(Long id, User updateUser) {
        User userById = getById(id);
        if (userById == null) {
            throw new EntityNotFoundException();
        }
        userById.setName(updateUser.getName());
        userById.setLastName(updateUser.getLastName());
        userById.setAge(updateUser.getAge());
        userDao.update(userById);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        User userById = getById(id);
        if (userById == null) {
           throw new EntityNotFoundException(String.valueOf(id));
        }
        userDao.delete(userById);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
