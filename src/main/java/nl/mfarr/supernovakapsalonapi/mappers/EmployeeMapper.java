package nl.mfarr.supernovakapsalonapi.mappers;
import nl.mfarr.supernovakapsalonapi.dtos.EmployeeDto;
import nl.mfarr.supernovakapsalonapi.entities.EmployeeEntity;
import nl.mfarr.supernovakapsalonapi.entities.SkillEntity;
import nl.mfarr.supernovakapsalonapi.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class EmployeeMapper {

    @Autowired
    private SkillRepository skillRepository;

    public EmployeeEntity convertToEntity(EmployeeDto employeeDto, List<SkillEntity> skillEntities) {
        Set <SkillEntity> skillEntitiesSet = new HashSet<>(skillEntities);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setLastName(employeeDto.getLastName());
        employeeEntity.setEmail(employeeDto.getEmail());
        employeeEntity.setPhoneNumber(employeeDto.getPhoneNumber());
        employeeEntity.setSkills(skillEntitiesSet);
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
