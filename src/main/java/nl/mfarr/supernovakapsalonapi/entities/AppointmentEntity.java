package nl.mfarr.supernovakapsalonapi.entities;
import jakarta.persistence.*;
import nl.mfarr.supernovakapsalonapi.helpers.AppointmentDescriptionHelper;
import java.util.Set;

@Entity
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;


    @ManyToMany
    @JoinTable(name = "appointment_skill",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<SkillEntity> skills;

    private String description;

    @ManyToOne
    @JoinColumn(name = "availability_slot_id")
    private AvailabilitySlotEntity availabilitySlot;

public AppointmentEntity(Long id, CustomerEntity customer, EmployeeEntity employee, Set<SkillEntity> skills, String description, AvailabilitySlotEntity availabilitySlot) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.skills = skills;
        this.description = description;
        this.availabilitySlot = availabilitySlot;
    }

    public AppointmentEntity() {
    }

    public Long getId() {
        return id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public Set<SkillEntity> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillEntity> skills) {
        this.skills = skills;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(Set<SkillEntity> skills) {
        this.description = AppointmentDescriptionHelper.generateDescription(skills);
    }

    public AvailabilitySlotEntity getAvailabilitySlot() {
        return availabilitySlot;
    }

    public void setAvailabilitySlot(AvailabilitySlotEntity availabilitySlot) {
        this.availabilitySlot = availabilitySlot;
    }

}
