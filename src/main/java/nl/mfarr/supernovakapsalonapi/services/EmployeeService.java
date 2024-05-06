package nl.mfarr.supernovakapsalonapi.services;

import nl.mfarr.supernovakapsalonapi.entities.EmployeeEntity;
import nl.mfarr.supernovakapsalonapi.entities.SkillEntity;
import nl.mfarr.supernovakapsalonapi.mappers.EmployeeMapper;
import nl.mfarr.supernovakapsalonapi.mappers.SkillMapper;
import nl.mfarr.supernovakapsalonapi.repositories.EmployeeRepository;
import nl.mfarr.supernovakapsalonapi.dtos.EmployeeDto;
import nl.mfarr.supernovakapsalonapi.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, SkillRepository skillRepository, SkillMapper skillMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        var skillEntities = skillRepository.findAllById(employeeDto.getSkillId());
        EmployeeEntity employeeEntity = employeeMapper.convertToEntity(employeeDto, skillEntities);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);

        return employeeMapper.convertToDto(savedEmployee);
    }

    public List<EmployeeDto> createEmployees(List<EmployeeDto> employeeDtos) {
        return employeeDtos.stream().map(this::createEmployee).collect(Collectors.toList());
    }


    public Optional<EmployeeDto> getEmployeeById(Long id) {
        return employeeRepository.findById(id).map(employeeMapper::convertToDto);
    }

    public Optional<EmployeeDto> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email).map(employeeMapper::convertToDto);
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeMapper::convertToDto).collect(Collectors.toList());
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        var skillEntities = skillRepository.findAllById(employeeDto.getSkillId());
        EmployeeEntity employeeEntity = employeeMapper.convertToEntity(employeeDto, skillEntities);
        employeeEntity = employeeRepository.save(employeeEntity);
        return employeeMapper.convertToDto(employeeEntity);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto updateEmployeePartially(Long id, EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        if (employeeDto.getName() != null) {
            employeeEntity.setName(employeeDto.getName());
        }

        if (employeeDto.getLastName() != null) {
            employeeEntity.setLastName(employeeDto.getLastName());
        }

        if (employeeDto.getPhoneNumber() != null) {
            employeeEntity.setPhoneNumber(employeeDto.getPhoneNumber());
        }

        if (employeeDto.getEmail() != null) {
            employeeEntity.setEmail(employeeDto.getEmail());
        }

        if (employeeDto.getSkillId() != null) {
            if (employeeDto.getSkillId().isEmpty()) {
                employeeEntity.setSkills(new HashSet<>());
            } else {
                Set<SkillEntity> newSkillSet = employeeDto.getSkillId().stream()
                        .map(skillId -> skillRepository.findById(skillId)
                                .orElseThrow(() -> new ResourceNotFoundException("Skill not found")))
                        .collect(Collectors.toSet());
                employeeEntity.setSkills(newSkillSet);
            }
            employeeRepository.saveAndFlush(employeeEntity);
        }
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return employeeMapper.convertToDto(savedEmployee);
    }
}