package nl.mfarr.supernovakapsalonapi.entities;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;

    @ManyToMany(mappedBy = "employees")
    private Set<SkillEntity> skills;

    @OneToMany(mappedBy = "employee")
    private Set<AppointmentEntity> appointments;

    @OneToMany(mappedBy = "employee")
    private Set<AvailabilitySlotEntity> availabilitySlots;

    public EmployeeEntity(Long id, String name, String lastName, String email, String phoneNumber, Set<SkillEntity> skills, Set<AppointmentEntity> appointments, Set<AvailabilitySlotEntity> availabilitySlots) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
        this.appointments = appointments;
        this.availabilitySlots = availabilitySlots;
    }

    public EmployeeEntity() {
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
