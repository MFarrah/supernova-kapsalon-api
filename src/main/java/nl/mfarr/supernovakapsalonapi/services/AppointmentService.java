package nl.mfarr.supernovakapsalonapi.services;

import nl.mfarr.supernovakapsalonapi.dtos.*;
import nl.mfarr.supernovakapsalonapi.entities.*;
import nl.mfarr.supernovakapsalonapi.helpers.AppointmentDescriptionHelper;
import nl.mfarr.supernovakapsalonapi.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AppointmentService {


    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Set<SkillDto> skills = appointmentDto.getSkills();
        String description = AppointmentDescriptionHelper.generateDescription(appointmentDto.getSkills().stream().map(this::convertSkillToEntity).collect(Collectors.toSet()));
        appointmentDto.setDescription(description);

        AppointmentEntity appointment = convertToEntity(appointmentDto);
        AppointmentEntity savedAppointment = appointmentRepository.save(appointment);
        return convertToDto(savedAppointment);
    }

    public Optional<AppointmentDto> getAppointmentById(Long id) {
        return appointmentRepository.findById(id).map(this::convertToDto);
    }

    public List<AppointmentDto> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AppointmentDto updateAppointment(Long id, AppointmentDto appointmentDto) {
        String description = AppointmentDescriptionHelper.generateDescription(appointmentDto.getSkills().stream().map(this::convertSkillToEntity).collect(Collectors.toSet()));
        appointmentDto.setDescription(description);

        AppointmentEntity appointment = convertToEntity(appointmentDto);
        appointment = appointmentRepository.save(appointment);
        return convertToDto(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }


    private CustomerEntity convertCustomerToEntity(CustomerDto customerDto) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(customerDto.getName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        return customer;
    }

    private CustomerDto convertCustomerToDto(CustomerEntity customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        return customerDto;
    }

    private EmployeeEntity convertEmployeeToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setName(employeeDto.getName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        return employee;
    }

    private EmployeeDto convertEmployeeToDto(EmployeeEntity employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        return employeeDto;
    }

    private SkillEntity convertSkillToEntity(SkillDto skillDto) {
        SkillEntity skill = new SkillEntity();
        skill.setId(skillDto.getId());
        skill.setName(skillDto.getName());
        skill.setDescription(skillDto.getDescription());
        skill.setPrice(skillDto.getPrice());
        return skill;
    }

    private SkillDto convertSkillToDto(SkillEntity skill) {
        SkillDto skillDto = new SkillDto();
        skillDto.setId(skill.getId());
        skillDto.setName(skill.getName());
        skillDto.setDescription(skill.getDescription());
        skillDto.setPrice(skill.getPrice());
        return skillDto;
    }

    private AvailabilitySlotEntity convertAvailabilitySlotToEntity(AvailabilitySlotDto availabilitySlotDto) {
        AvailabilitySlotEntity availabilitySlot = new AvailabilitySlotEntity();
        availabilitySlot.setId(availabilitySlotDto.getId());
        availabilitySlot.setDayOfWeek(availabilitySlotDto.getDayOfWeek());
        availabilitySlot.setStartTime(availabilitySlotDto.getStartTime());
        availabilitySlot.setEndTime(availabilitySlotDto.getEndTime());
        return availabilitySlot;
    }

    private AvailabilitySlotDto convertAvailabilitySlotToDto(AvailabilitySlotEntity availabilitySlot) {
        AvailabilitySlotDto availabilitySlotDto = new AvailabilitySlotDto();
        availabilitySlotDto.setId(availabilitySlot.getId());
        availabilitySlotDto.setDayOfWeek(availabilitySlot.getDayOfWeek());
        availabilitySlotDto.setStartTime(availabilitySlot.getStartTime());
        availabilitySlotDto.setEndTime(availabilitySlot.getEndTime());
        return availabilitySlotDto;
    }

    private AppointmentEntity convertToEntity(AppointmentDto appointmentDto) {
        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setCustomer(convertCustomerToEntity(appointmentDto.getCustomer()));
        appointment.setEmployee(convertEmployeeToEntity(appointmentDto.getEmployee()));
        appointment.setSkills(appointmentDto.getSkills().stream().map(this::convertSkillToEntity).collect(Collectors.toSet()));
        appointment.setDescription(AppointmentDescriptionHelper.generateDescription(appointment.getSkills()));
        appointment.setAvailabilitySlot(convertAvailabilitySlotToEntity(appointmentDto.getAvailabilitySlot()));
        return appointment;
    }

    private AppointmentDto convertToDto(AppointmentEntity appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setCustomer(convertCustomerToDto(appointment.getCustomer()));
        appointmentDto.setEmployee(convertEmployeeToDto(appointment.getEmployee()));
        appointmentDto.setSkills(appointment.getSkills().stream().map(this::convertSkillToDto).collect(Collectors.toSet()));
        appointmentDto.setDescription(AppointmentDescriptionHelper.generateDescriptionDto(appointmentDto.getSkills()));
        appointmentDto.setAvailabilitySlot(convertAvailabilitySlotToDto(appointment.getAvailabilitySlot()));
        return appointmentDto;
    }
}