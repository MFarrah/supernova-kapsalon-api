package nl.mfarr.supernovakapsalonapi.dtos;
import nl.mfarr.supernovakapsalonapi.helpers.AppointmentDescriptionHelper;
import java.util.Set;


public class AppointmentDto {

    private Long id;
    private CustomerDto customer;
    private EmployeeDto employee;
    private Set<SkillDto> skills;
    private String description;
    private AvailabilitySlotDto availabilitySlot;

    public AppointmentDto(Long id, CustomerDto customer, EmployeeDto employee, Set<SkillDto> skills, String description, AvailabilitySlotDto availabilitySlot) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.skills = skills;
        this.description = description;
        this.availabilitySlot = availabilitySlot;
    }

    public AppointmentDto() {
    }

    public Long getId() {
        return id;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public Set<SkillDto> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillDto> skills) {
        this.skills = skills;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(Set<SkillDto> skills) {
        this.description = AppointmentDescriptionHelper.generateDescriptionDto(skills);
    }

    public AvailabilitySlotDto getAvailabilitySlot() {
        return availabilitySlot;
    }

    public void setAvailabilitySlot(AvailabilitySlotDto availabilitySlot) {
        this.availabilitySlot = availabilitySlot;
    }

}
