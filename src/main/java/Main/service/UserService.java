package Main.service;

import Main.model.User;

import java.util.List;

public interface UserService<T> {
    void add(User user);
    void dell(int id);
    void update(User user);

    List<User> getAllUser();


}
