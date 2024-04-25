package nl.mfarr.supernovakapsalonapi.dtos;


import java.util.Collection;
import java.util.Set;


public class EmployeeDto {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
<<<<<<< HEAD
    private Set<Long> skillid; // changed from Set<SkillEntity> to Set<Long> // create a new method in employeeservice toconvert the set of longs to a set of skills
    private Set <SkillDto> skills;
    private Set<AppointmentEntity> appointments;
    private Set<AvailabilitySlotEntity> availabilitySlots;

=======
    private Set<Long> skillId;
    private SkillDto skills;
    private Set<Long> appointments;
    private Set<Long> availabilitySlots;
>>>>>>> feature/services

    public void setSkills(SkillDto skills) {
        this.skills = skills;
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

<<<<<<< HEAD
    public Set<Long> getSkillid() {
        return skillid;
    }

    public void setSkillid(Set<Long> skillid) {
        this.skillid = skillid;
    }

    public Set<SkillDto> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillDto> skills) {
        this.skills = skills;
=======
    public Set<Long> getSkills() {
        return skillId;
    }

    public void setSkillId(Set<Long> skillId) {
        this.skillId = skillId;
>>>>>>> feature/services
    }

    public Set<Long> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Long> appointments) {
        this.appointments = appointments;
    }

    public Set<Long> getAvailabilitySlots() {
        return availabilitySlots;
    }

    public void setAvailabilitySlots(Set<Long> availabilitySlots) {
        this.availabilitySlots = availabilitySlots;
    }

    public Collection<Object> getSkillId() {
        return null;
    }
}
