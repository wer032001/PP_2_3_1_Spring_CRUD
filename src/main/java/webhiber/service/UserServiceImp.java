package webhiber.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import webhiber.dao.UserDao;
import webhiber.model.User;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    public User updateUser(User user) {
       return this.userDao.updateUser(user);
    }

    @Override
    public void removeUser(long id) {
        this.userDao.removeUser(id);
    }

    @Override
    public User getUserById(long id) {
        return this.userDao.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }

}
