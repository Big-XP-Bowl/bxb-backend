package dat3.bxb.schedule;

import dat3.bxb.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Schedule {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Employee employee;

    public Schedule(LocalDateTime startTime, LocalDateTime endTime, Employee employee) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.employee = employee;
    }

    public Schedule() {
    }

    public void setEmployeeId(int employeeId) {
        this.employee = new Employee();
        this.employee.setId(employeeId);
    }
}