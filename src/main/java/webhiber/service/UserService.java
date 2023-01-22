package webhiber.service;

import webhiber.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User updateUser(User user);
    void removeUser(long id);
    User getUserById(long id);
    List<User> listUsers();
}
