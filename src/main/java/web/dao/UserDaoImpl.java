package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
  /*  private static int ID_USER;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++ID_USER, "Oleg", 30));
        users.add(new User(++ID_USER, "Renat", 20));
        users.add(new User(++ID_USER, "Nikolay", 40));
    }*/
  private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> printUsers() {
                return sessionFactory.getCurrentSession().createQuery("from User").list();//users;
    }
    @Override
    public User getById(int id){
       return sessionFactory.getCurrentSession().get(User.class, id);
        // return users.stream().filter(user -> user.getId()==id).findAny().orElse(null);
    }
    @Override
    public void save(User user){
        sessionFactory.getCurrentSession().persist(user);
        /*user.setId(++ID_USER);
        users.add(user);*/
    }
    @Override
    public void update(User user){
        sessionFactory.getCurrentSession().update(user);
        /*User userUpdate = users.stream().filter(useru -> useru.getId()==user.getId()).findAny().orElse(null);
        userUpdate.setName(user.getName());
        userUpdate.setAge(user.getAge());*/
    }
    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
        // users.removeIf(u -> u.getId() == user.getId());
    }
}
