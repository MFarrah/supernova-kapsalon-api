package nl.mfarr.supernovakapsalonapi.entities;
import java.time.LocalDateTime;

public class AppointmentEntity {

        private Long id;
        private LocalDateTime dateTime;
        private CustomerEntity customer;
        private EmployeeEntity employee;
        private boolean confirmed;
        private boolean cancelled;
        private boolean completed;
        private boolean noShow;

}
