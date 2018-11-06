package bsz.dao;

import bsz.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by szb on 10/23/18.
 */
public class UserDao  {

    private Map<Long, User> Users = new HashMap<>();

    public UserDao() {
        User user1 = createNewUser("f1", "l1", "e1");
        User user2 = createNewUser("f2", "l2", "e2");
        Users.put(user1.getId(), user1);
        Users.put(user2.getId(), user2);
    }

    public @Nullable
    User getById(Long id){
     return Users.get(id);
    }

    public @Nullable
    User getUserByEmail(@Nonnull String email) {
        final User[] retval = {null};
                Users.forEach((id, user) -> {
            if (user.getEmail().equals(email)) {
                retval[0] = user;
            }
        });
        return retval[0];
    }

    public @Nullable
    List<User> getAll() {
        List userList = new ArrayList();
        Users.forEach((id, user) -> {
            userList.add(user);
        });
        return userList;
    }

    public @Nullable
    User save(User user) {
        long id = user.getId();
        Users.put(id, user);
        return user;
    }

    public void remove(User User) {
        Users.remove(User.getId());
    }

    public @Nullable
    User createNewUser(String firstName, String lastName, String email) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setId((long) user.hashCode());
        return user;
    }

    public User createNewUser() {
        return new User();
    }
}
