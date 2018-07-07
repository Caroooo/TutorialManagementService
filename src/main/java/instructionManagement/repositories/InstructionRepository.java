package instructionManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import instructionManagement.model.Instruction;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InstructionRepository extends JpaRepository<Instruction, Long> {
}
