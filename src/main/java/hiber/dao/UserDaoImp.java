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
   public void add(User user) {
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return null;
   }


}
