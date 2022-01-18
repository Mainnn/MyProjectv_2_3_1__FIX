package Main.service;

import Main.model.User;

import java.util.List;

public interface UserService<T> {
    void add(User user);
    void dell(int id);
    void update(int id,String firstName,String lastName);

    List<User> getAllUser();


}
