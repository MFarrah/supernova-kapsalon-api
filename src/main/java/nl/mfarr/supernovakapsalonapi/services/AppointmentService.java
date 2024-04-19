package nl.mfarr.supernovakapsalonapi.services;

import nl.mfarr.supernovakapsalonapi.mappers.AppointmentMapper;
import nl.mfarr.supernovakapsalonapi.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

}