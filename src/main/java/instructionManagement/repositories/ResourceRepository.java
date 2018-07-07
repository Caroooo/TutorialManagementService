package instructionManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import instructionManagement.model.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
