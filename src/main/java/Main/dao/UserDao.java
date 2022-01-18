package Main.dao;


import Main.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void update(int id,String firstName,String lastName);
   void dell(int id);
   List<User> getAllUser();
}
