package dat3.bxb.employee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        employee.setId(employeeDTO.getId());
        employee.setEmpType(Employee.EmpType.valueOf(employeeDTO.getEmpType()));
        employee.setName(employeeDTO.getName());
        employee.setInitials(employeeDTO.getInitials());
        employee.setImageUrl(employeeDTO.getImageUrl());
        Employee savedEmployee = employeeRepository.save(employee); // Save the employee
        return convertToDTO(savedEmployee); // Convert and return the saved employee as DTO
    }

    public EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setEmpType(employee.getEmpType().toString()); // Convert enum to String
        dto.setName(employee.getName());
        dto.setInitials(employee.getInitials());
        dto.setImageUrl(employee.getImageUrl());
        return dto;
    }

    public List<EmployeeDTO> getEmployeesByEmpType(String empType) {
        Employee.EmpType type = Employee.EmpType.valueOf(empType.toUpperCase());
        List<Employee> employees = employeeRepository.findByEmpType(type);
        return employees.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public EmployeeDTO updateEmployee(int id, EmployeeDTO employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + id));
        existingEmployee.setEmpType(Employee.EmpType.valueOf(employee.getEmpType()));
        existingEmployee.setName(employee.getName());
        existingEmployee.setInitials(employee.getInitials());
        existingEmployee.setImageUrl(employee.getImageUrl());
        Employee savedEmployee = employeeRepository.save(existingEmployee); // Save the updated employee
        return convertToDTO(savedEmployee); // Convert and return the updated employee as DTO
    }
}
