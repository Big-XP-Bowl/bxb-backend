package dat3.bxb.schedule;

import dat3.bxb.employee.Employee;
import dat3.bxb.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final EmployeeRepository employeeRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, EmployeeRepository employeeRepository) {
        this.scheduleRepository = scheduleRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream().map(this::convertToDTO).toList();
    }

    public ScheduleDTO getScheduleById(int id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found with ID: " + id));
        return convertToDTO(schedule);
    }

    public List<ScheduleDTO> getSchedulesByEmployeeId(int employeeId) {
        List<Schedule> schedules = scheduleRepository.findByEmployee_Id(employeeId);
        return schedules.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        schedule.setStartTime(LocalDateTime.parse(scheduleDTO.getStartTime()));
        schedule.setEndTime(LocalDateTime.parse(scheduleDTO.getEndTime()));

        // Retrieve the Employee entity and set it on the Schedule
        Employee employee = employeeRepository.findById(scheduleDTO.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + scheduleDTO.getEmployeeId()));
        schedule.setEmployee(employee);

        validateSchedule(schedule);
        scheduleRepository.save(schedule);
        return scheduleDTO;
    }

    public ScheduleDTO updateSchedule(int id, ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found with ID: " + id));
        schedule.setStartTime(LocalDateTime.parse(scheduleDTO.getStartTime()));
        schedule.setEndTime(LocalDateTime.parse(scheduleDTO.getEndTime()));

        Employee employee = employeeRepository.findById(scheduleDTO.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + scheduleDTO.getEmployeeId()));
        schedule.setEmployee(employee);

        validateSchedule(schedule);
        scheduleRepository.save(schedule);
        return scheduleDTO;
    }

    public void deleteSchedule(int id) {
        scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found with ID: " + id));
        scheduleRepository.deleteById(id);
    }

    public ScheduleDTO convertToDTO(Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setStartTime(schedule.getStartTime().toString());
        scheduleDTO.setEndTime(schedule.getEndTime().toString());
        scheduleDTO.setEmployeeId(schedule.getEmployee().getId());
        return scheduleDTO;
    }

    private void validateSchedule(Schedule schedule) {
        checkDuplicateEmployeeInShift(schedule);
        validateShiftTimes(schedule);
        checkEmployeeTypeLimits(schedule);
    }

    private void checkDuplicateEmployeeInShift(Schedule schedule) {
        boolean exists = scheduleRepository.existsByEmployee_IdAndStartTime(schedule.getEmployee().getId(), schedule.getStartTime());
        if (exists) {
            throw new IllegalArgumentException("Employee is already scheduled for this shift.");
        }
    }

    private void validateShiftTimes(Schedule schedule) {
        LocalDateTime startTime = schedule.getStartTime();
        LocalDateTime endTime = schedule.getEndTime();
        LocalTime start = startTime.toLocalTime();
        LocalTime end = endTime.toLocalTime();

        if (!(start.equals(LocalTime.of(9, 0)) && end.equals(LocalTime.of(16, 0))) &&
                !(start.equals(LocalTime.of(16, 0)) && end.equals(LocalTime.of(23, 0)))) {
            throw new IllegalArgumentException("Shift times must be 9:00 to 16:00 or 16:00 to 23:00.");
        }
    }

    private void checkEmployeeTypeLimits(Schedule schedule) {
        LocalDate date = schedule.getStartTime().toLocalDate();
        List<Schedule> schedules = scheduleRepository.findByStartTimeBetween(
                date.atStartOfDay(), date.plusDays(1).atStartOfDay());

        Map<Employee.EmpType, Long> typeCounts = schedules.stream()
                .collect(Collectors.groupingBy(s -> s.getEmployee().getEmpType(), Collectors.counting()));

        Employee.EmpType empType = schedule.getEmployee().getEmpType();
        long count = typeCounts.getOrDefault(empType, 0L);

        if ((empType == Employee.EmpType.CLEANING && count >= 2) ||
                (empType == Employee.EmpType.MANAGER && count >= 1) ||
                (empType == Employee.EmpType.MAINTENANCE && count >= 1) ||
                (empType == Employee.EmpType.BAR && count >= 2)) {
            throw new IllegalArgumentException("Exceeded the number of allowed employees for type: " + empType);
        }
    }
}