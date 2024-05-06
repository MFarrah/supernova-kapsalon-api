package nl.mfarr.supernovakapsalonapi.repositories;

import nl.mfarr.supernovakapsalonapi.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByEmail(String email);

    @Query("SELECT e FROM EmployeeEntity e JOIN e.skills s WHERE s.id = :skillId")
    List<EmployeeEntity> findBySkillId(Long skillId);

}


