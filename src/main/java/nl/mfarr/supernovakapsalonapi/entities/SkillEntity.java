package nl.mfarr.supernovakapsalonapi.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;
@Entity
public class SkillEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String description;
        private double price;

        @ManyToMany
        @JoinTable(name = "employee_skill",
                joinColumns = @JoinColumn(name = "skill_id"),
                inverseJoinColumns = @JoinColumn(name = "employee_id"))
        private Set<EmployeeEntity> employees;

        public SkillEntity(Long id, String name, String description, double price, Set<EmployeeEntity> employees) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.employees = employees;
        }

        public SkillEntity() {
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

        public Set<EmployeeEntity> getEmployees() {
                return employees;
        }

        public void setEmployees(Set<EmployeeEntity> employees) {
                this.employees = employees;
        }
}
