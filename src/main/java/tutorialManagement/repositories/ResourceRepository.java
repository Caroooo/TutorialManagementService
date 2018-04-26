package tutorialManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutorialManagement.model.Resource;
import tutorialManagement.model.Tutorial;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
