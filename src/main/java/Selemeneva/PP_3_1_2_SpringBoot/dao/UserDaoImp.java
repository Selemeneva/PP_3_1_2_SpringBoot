package Selemeneva.PP_3_1_2_SpringBoot.dao;

import Selemeneva.PP_3_1_2_SpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showAllUsers() {
        List<User> allUsers = entityManager.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User user) {
        User updateUser = entityManager.find(User.class, id);
        updateUser.setName(user.getName());
        updateUser.setLastname(user.getLastname());
        updateUser.setAge(user.getAge());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());
    }

    @Override
    public void deleteUser(int id) {
        User removeUser = entityManager.find(User.class, id);
        entityManager.remove(removeUser);
    }


}
