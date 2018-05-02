package tutorialManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutorialManagement.model.TutorialChildStep;
import tutorialManagement.model.TutorialStep;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TutorialChildStepRepository extends JpaRepository<TutorialChildStep, Long> {
}
