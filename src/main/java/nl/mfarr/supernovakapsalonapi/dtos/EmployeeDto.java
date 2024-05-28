package nl.mfarr.supernovakapsalonapi.dtos;


import nl.mfarr.supernovakapsalonapi.entities.AppointmentEntity;
import nl.mfarr.supernovakapsalonapi.entities.AvailabilitySlotEntity;

import java.util.Collection;
import java.util.Set;


public class EmployeeDto {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<Long> skillId;
    private Set <SkillDto> skills;
    private Set<AppointmentDto> appointments;
    private Set<AvailabilitySlotDto> availabilitySlots;


    public EmployeeDto(Long id, String name, String lastName, String email, String phoneNumber, Set<Long> skillId, Set<SkillDto> skills, Set<AppointmentDto> appointments, Set<AvailabilitySlotDto> availabilitySlots) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.skillId = skillId;
        this.skills = skills;
        this.appointments = appointments;
        this.availabilitySlots = availabilitySlots;
    }

    public EmployeeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }


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

    public Set<Long> getSkillId() {
        return skillId;
    }

    public void setSkillId(Set<Long> skillId) {
        this.skillId = skillId;
    }

    public Set<SkillDto> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillDto> skills) {
        this.skills = skills;
    }

    public Set<AppointmentDto> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<AppointmentDto> appointments) {
        this.appointments = appointments;
    }

    public Set<AvailabilitySlotDto> getAvailabilitySlots() {
        return availabilitySlots;
    }

    public void setAvailabilitySlots(Set<AvailabilitySlotDto> availabilitySlots) {
        this.availabilitySlots = availabilitySlots;
    }

}
