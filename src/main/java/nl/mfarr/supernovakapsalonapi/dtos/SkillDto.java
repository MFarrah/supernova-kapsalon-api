package nl.mfarr.supernovakapsalonapi.dtos;
import nl.mfarr.supernovakapsalonapi.entities.EmployeeEntity;

import java.time.Duration;
import java.util.Set;

public class SkillDto {


    private Long id;
    private String name;
    private String description;
    private double price;
    private Duration duration;


    public SkillDto(Long id, String name, String description, double price, Duration duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

}
