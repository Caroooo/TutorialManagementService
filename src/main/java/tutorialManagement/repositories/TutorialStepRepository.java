package tutorialManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutorialManagement.model.Tutorial;
import tutorialManagement.model.TutorialStep;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TutorialStepRepository extends JpaRepository<TutorialStep, Long> {
}
