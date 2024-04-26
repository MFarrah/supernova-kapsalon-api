package nl.mfarr.supernovakapsalonapi.dtos;


import nl.mfarr.supernovakapsalonapi.entities.AppointmentEntity;
import nl.mfarr.supernovakapsalonapi.entities.AvailabilitySlotEntity;

import java.util.Collection;
import java.util.Set;


public class EmployeeDto {

    private Long id;
    private String name;
    private String lastNames;
    private String email;
    private String phoneNumber;
    private Set<Long> skillId; // changed from Set<SkillEntity> to Set<Long> // create a new method in employeeservice toconvert the set of longs to a set of skills
    private Set <SkillDto> skills;
    private Set<AppointmentEntity> appointments;
    private Set<AvailabilitySlotEntity> availabilitySlots;


    public EmployeeDto(Long id, String name, String lastName, String email, String phoneNumber, Set<Long> skillId, Set<SkillDto> skills, Set<AppointmentEntity> appointments, Set<AvailabilitySlotEntity> availabilitySlots) {
        this.id = id;
        this.name = name;
        this.lastNames = lastName;
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
        return lastNames;
    }

    public void setLastName(String lastName) {
        this.lastNames = lastName;
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
