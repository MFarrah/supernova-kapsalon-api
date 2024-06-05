package nl.mfarr.supernovakapsalonapi.dtos;
import nl.mfarr.supernovakapsalonapi.helpers.AppointmentDescriptionHelper;
import java.util.Set;


public class AppointmentDto {

    private Long id;
    private Long customerId;
    private Long employeeId;
    private Set<SkillDto> skills;
    private String description;
    private AvailabilitySlotDto availabilitySlot;

    public AppointmentDto(Long id, Long customerId, Long employeeId, Set<SkillDto> skills, String description, AvailabilitySlotDto availabilitySlot) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.skills = skills;
        this.description = description;
        this.availabilitySlot = availabilitySlot;
    }


    public AppointmentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

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

    public Set<SkillDto> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillDto> skills) {
        this.skills = skills;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
        }

    public AvailabilitySlotDto getAvailabilitySlot() {
        return availabilitySlot;
    }

    public void setAvailabilitySlot(AvailabilitySlotDto availabilitySlot) {
        this.availabilitySlot = availabilitySlot;
    }


}
