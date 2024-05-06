package nl.mfarr.supernovakapsalonapi.repositories;
import nl.mfarr.supernovakapsalonapi.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByEmail(String email);
}
