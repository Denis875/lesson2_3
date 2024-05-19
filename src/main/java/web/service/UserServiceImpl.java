package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
