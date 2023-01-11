package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String name;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   public User() {}
   
   public User(String name, String lastName, String email) {
      this.name = name;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public String getFirstName() {
      return name;
   }

   public String getLastName() {
      return lastName;
   }

   public String getEmail() {
      return email;
   }

   @Override
   public String toString() {
      return "Person " + getId()
              + " " + getEmail()
              + " " + getFirstName()
              + " " + getLastName();
   }

}
