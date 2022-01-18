package Main.service;


import Main.dao.UserDao;
import Main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   private UserDao userDao;
   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public void dell(int id) {
      userDao.dell(id);
   }

   @Override
   public void update(int id,String firstName,String lastName) {
      userDao.update(id,firstName,lastName);
   }
   @Override
   public List<User> getAllUser() {
      return userDao.getAllUser();
   }

}
