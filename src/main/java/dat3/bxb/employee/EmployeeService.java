package dat3.bxb.employee;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(this::convertToDTO).toList();
    }

    public EmployeeDTO getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + id));
        return convertToDTO(employee);
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmpType(Employee.EmpType.valueOf(employeeDTO.getEmpType()));
        employee.setName(employeeDTO.getName());
        employee.setInitials(employeeDTO.getInitials());
        Employee savedEmployee = employeeRepository.save(employee); // Save the employee
        return convertToDTO(savedEmployee); // Convert and return the saved employee as DTO
    }

    public EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmpType(employee.getEmpType().toString()); // Convert enum to String
        dto.setName(employee.getName());
        dto.setInitials(employee.getInitials());
        return dto;
    }
}
