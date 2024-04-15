package nl.mfarr.supernovakapsalonapi.services;

import nl.mfarr.supernovakapsalonapi.entities.AppointmentEntity;
import nl.mfarr.supernovakapsalonapi.repositories.AppointmentRepository;
import nl.mfarr.supernovakapsalonapi.dtos.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {


    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        AppointmentEntity appointment = convertToEntity(appointmentDto);
        appointment = appointmentRepository.save(appointment);
        return convertToDto(appointment);
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
        AppointmentEntity appointment = convertToEntity(appointmentDto);
        appointment = appointmentRepository.save(appointment);
        return convertToDto(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    private AppointmentEntity convertToEntity(AppointmentDto appointmentDto) {
        AppointmentEntity appointment = new AppointmentEntity();
        // Conversion logic here
        return appointment;
    }

    private AppointmentDto convertToDto(AppointmentEntity appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        // Conversion logic here
        return appointmentDto;
    }
}