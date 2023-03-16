package Main.dao;


import Main.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;
   @Override
   public void dell(int id) {
      User user = findeUser(id);
      entityManager.remove(user);
      entityManager.flush();
   }

   @Override
   public void add(User user) {
      entityManager.persist(user);
      entityManager.flush();
   }

   @Override
   public void update(User user) {
      entityManager.merge(user);
      entityManager.flush();
   }

   @Override
   public List<User> getAllUser() {
      return entityManager.createQuery("from User", User.class).getResultList();
   }

   private User findeUser(long id){
      return entityManager.find(User.class, id);
   }
}
