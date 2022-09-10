package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    public List<User> printUsers();

    public User getById(int id);

    public void save(User user);

    public void update(User user);

    public void delete(User user);
}
