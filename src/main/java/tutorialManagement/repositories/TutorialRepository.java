package tutorialManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutorialManagement.model.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
