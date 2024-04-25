package nl.mfarr.supernovakapsalonapi.dtos;
import nl.mfarr.supernovakapsalonapi.entities.EmployeeEntity;
import java.util.Set;

public class SkillDto {


    private Long id;
    private String name;
    private String description;
    private double price;
    private Set<Long> employeeId;
    private Set<EmployeeDto> employees;

    public SkillDto(Long id, String name, String description, double price, Set<Long> employeeId, Set<EmployeeDto> employees) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.employeeId = employeeId;
        this.employees = employees;
    }

    public SkillDto() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Long> getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Set<Long> employeeId) {
        this.employeeId = employeeId;
    }

    public Set<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeDto> employees) {
        this.employees = employees;
    }

}
