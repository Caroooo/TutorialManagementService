package instructionManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import instructionManagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

}
