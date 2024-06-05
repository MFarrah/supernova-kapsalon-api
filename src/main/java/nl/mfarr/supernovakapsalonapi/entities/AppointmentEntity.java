package nl.mfarr.supernovakapsalonapi.entities;
import jakarta.persistence.*;
import nl.mfarr.supernovakapsalonapi.helpers.AppointmentDescriptionHelper;
import java.util.Set;

@Entity
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name = "customer_id")
    private Long customerId;


    @JoinColumn(name = "employee_id")
    private Long employeeId;


    @ManyToMany
    @JoinTable(name = "appointment_skill",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<SkillEntity> skills;

    private String description;

    @ManyToOne
    @JoinColumn(name = "availability_slot_id")
    private AvailabilitySlotEntity availabilitySlot;

public AppointmentEntity(Long id, Long customerId, Long employeeId, Set<SkillEntity> skills, String description, AvailabilitySlotEntity availabilitySlot) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.skills = skills;
        this.description = description;
        this.availabilitySlot = availabilitySlot;
    }

    public AppointmentEntity() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    public Set<SkillEntity> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillEntity> skills) {
        this.skills = skills;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDescription(Set<SkillEntity> skills) {
        this.description = description;
    }

    public AvailabilitySlotEntity getAvailabilitySlot() {
        return availabilitySlot;
    }

    public void setAvailabilitySlot(AvailabilitySlotEntity availabilitySlot) {
        this.availabilitySlot = availabilitySlot;
    }

}
