package Main.model;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User  {

   @Id
   @GeneratedValue
   private Long id;


   private String firstName;


   private String lastName;

   @Override
   public String toString() {
      return "\nUser{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" +  '\'' +
              ", car=" +
              '}';
   }



   public User() {}
   
   public User(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public User(Long id, String firstName, String lastName) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

}
