package nl.mfarr.supernovakapsalonapi.repositories;
import nl.mfarr.supernovakapsalonapi.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByEmail(String email);

}
