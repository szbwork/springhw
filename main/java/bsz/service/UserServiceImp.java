package bsz.service;

import bsz.dao.UserDao;
import bsz.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * @author Barna_Szoke
 */
public class UserServiceImp implements UserService {

    UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    public UserDao getUserDao() {
//        return userDao;
//    }

    /**
     * Finding user by email
     * 
     * @param email
     *            Email of the user
     * @return found user or <code>null</code>
     */
    public @Nullable
    User getUserByEmail(@Nonnull String email) {
        return  userDao.getUserByEmail(email);
    }

    public @Nullable User getById(@Nonnull Long id) {
    return userDao.getById(id);
    }

    public Collection<User> getAll() {
        return userDao.getAll();
    }

    public void remove(@Nonnull User user) {
        userDao.remove(user);
    }

    public @Nullable User save(@Nonnull User user) {
        return userDao.save(user);
    }

    public @Nullable User createNewUser() {
        return userDao.createNewUser();
    }

    public @Nullable User createNewUser(String firstName, String lastName, String email) {
        return userDao.createNewUser(firstName, lastName, email);
    }

}
