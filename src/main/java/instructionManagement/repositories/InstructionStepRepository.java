package instructionManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import instructionManagement.model.InstructionStep;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InstructionStepRepository extends JpaRepository<InstructionStep, Long> {
}
