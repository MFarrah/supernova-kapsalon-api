package nl.mfarr.supernovakapsalonapi.repositories;
import nl.mfarr.supernovakapsalonapi.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
