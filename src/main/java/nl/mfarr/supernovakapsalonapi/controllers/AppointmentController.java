package nl.mfarr.supernovakapsalonapi.controllers;

import nl.mfarr.supernovakapsalonapi.dtos.AppointmentDto;
import nl.mfarr.supernovakapsalonapi.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {


    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        AppointmentDto createdAppointment = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AppointmentDto>> getAppointmentById(@PathVariable Long id) {
        Optional<AppointmentDto> appointmentDto = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(appointmentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto) {
        AppointmentDto updatedAppointment = appointmentService.updateAppointment(id, appointmentDto);
        return ResponseEntity.ok(updatedAppointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}