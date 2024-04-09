package nl.mfarr.supernovakapsalonapi.repositories;
import nl.mfarr.supernovakapsalonapi.entities.AvailabilitySlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilitySlotRepository extends JpaRepository<AvailabilitySlotEntity, Long> {
}
