package nl.mfarr.supernovakapsalonapi.entities;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

public class EmployeeEntity {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<SkillEntity> skills;
    private Set<AppointmentEntity> appointments;
    private Map<DayOfWeek, Set<LocalTime>> availability;

    public EmployeeEntity(Long id, String name, String lastName, String email, String phoneNumber, Set<SkillEntity> skills, Set<AppointmentEntity> appointments, Map<DayOfWeek, Set<LocalTime>> availability) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
        this.appointments = appointments;
        this.availability = availability;
    }

    public EmployeeEntity() {
    }

    public Long getId() {
        return id;
    }

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

    public Map<DayOfWeek, Set<LocalTime>> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<DayOfWeek, Set<LocalTime>> availability) {
        this.availability = availability;
    }
}
