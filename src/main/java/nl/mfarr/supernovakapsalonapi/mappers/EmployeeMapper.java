package nl.mfarr.supernovakapsalonapi.mappers;
import nl.mfarr.supernovakapsalonapi.dtos.EmployeeDto;
import nl.mfarr.supernovakapsalonapi.entities.EmployeeEntity;
import nl.mfarr.supernovakapsalonapi.entities.SkillEntity;
import nl.mfarr.supernovakapsalonapi.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@Component
public class EmployeeMapper {

    @Autowired
    private SkillRepository skillRepository;

    public EmployeeEntity convertToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setLastName(employeeDto.getLastName());
        employeeEntity.setEmail(employeeDto.getEmail());
        employeeEntity.setPhoneNumber(employeeDto.getPhoneNumber());
<<<<<<< HEAD
        employeeEntity.setSkills(null);
        employeeEntity.setAppointments(null);
        employeeEntity.setAvailabilitySlots(null);
=======

        Set<SkillEntity> skills = employeeDto.getSkills().stream()
                .map(skillId -> skillRepository.findById(skillId).orElse(null))
                .collect(Collectors.toSet());
        employeeEntity.setSkills(skills);
>>>>>>> feature/services

        return employeeEntity;
    }

    public EmployeeDto convertToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employeeEntity.getId());
        employeeDto.setName(employeeEntity.getName());
        employeeDto.setLastName(employeeEntity.getLastName());
        employeeDto.setEmail(employeeEntity.getEmail());
        employeeDto.setPhoneNumber(employeeEntity.getPhoneNumber());
<<<<<<< HEAD
        employeeDto.setSkills(null);
        employeeDto.setAppointments(null);
        employeeDto.setAvailabilitySlots(null);
=======


        Set<Long> skillIds = employeeEntity.getSkills().stream()
                .map(SkillEntity::getId)
                .collect(Collectors.toSet());

>>>>>>> feature/services

        return employeeDto;
    }
}
