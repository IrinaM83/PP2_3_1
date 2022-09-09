package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static int ID_USER;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++ID_USER, "Oleg", 30));
        users.add(new User(++ID_USER, "Renat", 20));
        users.add(new User(++ID_USER, "Nikolay", 40));
    }

    @Override
    public List<User> printUsers() {
                return users;
    }
    @Override
    public User getById(int id){
        return users.stream().filter(user -> user.getId()==id).findAny().orElse(null);
    }
    @Override
    public void save(User user){
        user.setId(++ID_USER);
        users.add(user);
    }
    @Override
    public void update(User user){
        User userUpdate = users.stream().filter(useru -> useru.getId()==user.getId()).findAny().orElse(null);
        userUpdate.setName(user.getName());
        userUpdate.setAge(user.getAge());
    }
    @Override
    public void delete(User user) {
        users.removeIf(u -> u.getId() == user.getId());
    }
}
