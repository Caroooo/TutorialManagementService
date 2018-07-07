package instructionManagement.repositories;

import instructionManagement.model.LevelMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelMappingRepository extends JpaRepository<LevelMapping, Long> {
}
