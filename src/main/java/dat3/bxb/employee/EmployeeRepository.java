package dat3.bxb.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);
    List<Employee> findByEmpType(Employee.EmpType empType);
}
