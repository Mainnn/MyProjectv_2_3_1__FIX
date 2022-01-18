package Main.model;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User  {

   @Id
   @GeneratedValue
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
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

    public int getId() {
      return Math.toIntExact(id);
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
