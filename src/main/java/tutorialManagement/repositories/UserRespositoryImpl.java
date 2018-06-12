package tutorialManagement.repositories;

import org.springframework.stereotype.Repository;
import tutorialManagement.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class UserRespositoryImpl implements UserRepositoryCustom{

    EntityManager entityManager;

    @Override
    public User findUserByUserNameAndPassword(String username, String password) {
        if(username != null && password != null){
       /*     Query query = entityManager.createNativeQuery("SELECT * FROM user as u" +
                    "WHERE u.userName = ? AND u.password= ?", User.class);
            query.setParameter(1, username);
            query.setParameter(2, password);
            return (User) query.getResultList().get(0);*/
       return new User();
        }
        return null;
    }
}
