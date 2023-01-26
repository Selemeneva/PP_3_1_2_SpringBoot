package Selemeneva.PP_3_1_2_SpringBoot.dao;




import Selemeneva.PP_3_1_2_SpringBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> showAllUsers();
    void saveUser(User user);
    User showUser(int id);
    void updateUser(int id, User user);
    void deleteUser(int id);
}
