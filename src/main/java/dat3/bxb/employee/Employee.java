package dat3.bxb.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private EmpType empType;

    private String name;
    private String initials;
    private String imageUrl;

    public Employee(EmpType empType, String name, String initials, String imageUrl) {
        this.empType = empType;
        this.name = name;
        this.initials = initials;
        this.imageUrl = imageUrl;
    }

    public Employee() {
    }

    public enum EmpType {
        @JsonProperty("MANAGER")
        MANAGER,
        @JsonProperty("BAR")
        BAR,
        @JsonProperty("MAINTENANCE")
        MAINTENANCE,

        @JsonProperty("CLEANING")
        CLEANING,
    }
}