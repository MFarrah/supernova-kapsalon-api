package nl.mfarr.supernovakapsalonapi.dtos;
import nl.mfarr.supernovakapsalonapi.entities.AppointmentEntity;
import nl.mfarr.supernovakapsalonapi.entities.AvailabilitySlotEntity;
import nl.mfarr.supernovakapsalonapi.entities.SkillEntity;

import java.util.Set;


public class EmployeeDto {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<SkillEntity> skills;
    private Set<AppointmentEntity> appointments;
    private Set<AvailabilitySlotEntity> availabilitySlots;



    public EmployeeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<SkillEntity> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillEntity> skills) {
        this.skills = skills;
    }

    public Set<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }

    public Set<AvailabilitySlotEntity> getAvailabilitySlots() {
        return availabilitySlots;
    }

    public void setAvailabilitySlots(Set<AvailabilitySlotEntity> availabilitySlots) {
        this.availabilitySlots = availabilitySlots;
    }

    }
