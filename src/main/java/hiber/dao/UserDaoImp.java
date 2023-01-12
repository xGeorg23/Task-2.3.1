package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void addUser(User user) {
      entityManager.persist(user);
   }

   @Override
   public List<User> getUsers() {
      return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
   }

   @Override
   public User getUserById(int id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void updateUser(User user) {
      User userToBeUpdate = entityManager.find(User.class, user.getId());
      userToBeUpdate.setName(user.getName());
      userToBeUpdate.setLastName(user.getLastName());
      userToBeUpdate.setEmail(user.getEmail());
   }

   @Override
   public void deleteUser(long id) {
      User user = entityManager.find(User.class, id);
      entityManager.remove(user);
   }
}