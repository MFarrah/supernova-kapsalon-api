package nl.mfarr.supernovakapsalonapi.repositories;
import nl.mfarr.supernovakapsalonapi.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
}
