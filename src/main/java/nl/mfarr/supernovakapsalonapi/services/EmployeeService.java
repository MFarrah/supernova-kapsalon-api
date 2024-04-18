package nl.mfarr.supernovakapsalonapi.services;

import nl.mfarr.supernovakapsalonapi.entities.EmployeeEntity;
import nl.mfarr.supernovakapsalonapi.mappers.EmployeeMapper;
import nl.mfarr.supernovakapsalonapi.repositories.EmployeeRepository;
import nl.mfarr.supernovakapsalonapi.dtos.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

@Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeMapper.convertToEntity(employeeDto);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return employeeMapper.convertToDto(savedEmployee);
    }

    public Optional<EmployeeDto> getEmployeeById(Long id) {
        return employeeRepository.findById(id).map(employeeMapper::convertToDto);
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeMapper::convertToDto).collect(Collectors.toList());
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeMapper.convertToEntity(employeeDto);
        employeeEntity = employeeRepository.save(employeeEntity);
        return employeeMapper.convertToDto(employeeEntity);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}