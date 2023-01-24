package webhiber.dao;

import org.springframework.stereotype.Repository;
import webhiber.config.AppConfig;
import webhiber.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final AppConfig appConfig;

    public UserDaoImp(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public void addUser(User user) {
        appConfig.createEntityManager().getTransaction().begin();
        appConfig.createEntityManager().persist(user);
        appConfig.createEntityManager().getTransaction().commit();
    }

    @Override
    public User updateUser(User user, long id) {
        appConfig.createEntityManager().getTransaction().begin();
        getUserById(id);
        appConfig.createEntityManager().merge(user);
        appConfig.createEntityManager().getTransaction().commit();
        return user;
    }

    @Override
    public void removeUser(long id) {
        appConfig.createEntityManager().getTransaction().begin();
        User user = appConfig.createEntityManager().find(User.class, id);
        appConfig.createEntityManager().remove(user);
        appConfig.createEntityManager().getTransaction().commit();
    }

    @Override
    public User getUserById(long id) {
        return appConfig.createEntityManager().find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return appConfig.createEntityManager().createQuery("from User").getResultList();
    }
}
