package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        User userForDelete = entityManager.find(User.class, id);
        if (userForDelete != null) {
            entityManager.remove(userForDelete);
        }
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
