package instructionManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import instructionManagement.model.User;

import javax.transaction.Transactional;

public interface UserRepositoryCustom {
    User findUserByUserNameAndPassword(String username, String password);
}
