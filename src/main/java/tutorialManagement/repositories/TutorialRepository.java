package tutorialManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutorialManagement.model.Tutorial;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
