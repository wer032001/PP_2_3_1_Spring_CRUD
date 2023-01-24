package webhiber.dao;

import webhiber.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    User updateUser(User user, long id);
    void removeUser(long id);
    User getUserById(long id);
    List<User> listUsers();

}
