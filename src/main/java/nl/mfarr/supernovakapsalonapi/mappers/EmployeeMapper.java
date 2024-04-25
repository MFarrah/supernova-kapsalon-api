package nl.mfarr.supernovakapsalonapi.mappers;
import nl.mfarr.supernovakapsalonapi.dtos.EmployeeDto;
import nl.mfarr.supernovakapsalonapi.entities.EmployeeEntity;
import org.springframework.stereotype.Component;



@Component
public class EmployeeMapper {

    public EmployeeEntity convertToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setLastName(employeeDto.getLastName());
        employeeEntity.setEmail(employeeDto.getEmail());
        employeeEntity.setPhoneNumber(employeeDto.getPhoneNumber());
        employeeEntity.setSkills(null);
        employeeEntity.setAppointments(null);
        employeeEntity.setAvailabilitySlots(null);

        return employeeEntity;
    }

    public EmployeeDto convertToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employeeEntity.getId());
        employeeDto.setName(employeeEntity.getName());
        employeeDto.setLastName(employeeEntity.getLastName());
        employeeDto.setEmail(employeeEntity.getEmail());
        employeeDto.setPhoneNumber(employeeEntity.getPhoneNumber());
        employeeDto.setSkills(null);
        employeeDto.setAppointments(null);
        employeeDto.setAvailabilitySlots(null);

        return employeeDto;
    }
}
