package Main;

import Main.config.JavaConfig;
import Main.model.User;
import Main.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      GenericApplicationContext context =
            new AnnotationConfigApplicationContext(JavaConfig.class);

      UserService userService = context.getBean(UserService.class);



//      userService.add(new User("User1", "Lastname31", "user1@mail.ru"));
//      userService.add(new User("User1", "Lastnam312e1", "user1@mail.ru"));
//      userService.add(new User("User1", "Lastn312ame1", "user1@mail.ru"));

      List<User> users = userService.getAllUser();

      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println();
      }
      context.close();
   }
}
