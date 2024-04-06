package nl.mfarr.supernovakapsalonapi.entities;

import nl.mfarr.supernovakapsalonapi.helpers.AppointmentDescriptionHelper;

import java.time.LocalDateTime;
import java.util.Set;

public class AppointmentEntity {

    private Long id;
    private CustomerEntity customer;
    private EmployeeEntity employee;
    private LocalDateTime startTime;
    private Set<SkillEntity> skills;
    private String description;

    public AppointmentEntity(Long id, CustomerEntity customer, EmployeeEntity employee, LocalDateTime startTime, LocalDateTime endTime, Set<SkillEntity> skills, String description) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.startTime = startTime;
        this.skills = skills;
        this.description = description;
    }

    public AppointmentEntity() {
    }

    public Long getId() {
        return id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }


    public Set<SkillEntity> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillEntity> skills) {
        this.skills = skills;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(Set<SkillEntity> skills) {
        this.description = AppointmentDescriptionHelper.generateDescription(skills);
    }

}
