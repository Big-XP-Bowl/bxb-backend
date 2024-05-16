package dat3.bxb.schedule;

import dat3.bxb.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
        schedule.setEmployeeId(scheduleDTO.getEmployeeId());
        scheduleRepository.save(schedule);
        return scheduleDTO;
    }

    public ScheduleDTO updateSchedule(int id, ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found with ID: " + id));
        schedule.setStartTime(LocalDateTime.parse(scheduleDTO.getStartTime()));
        schedule.setEndTime(LocalDateTime.parse(scheduleDTO.getEndTime()));
        schedule.setEmployeeId(scheduleDTO.getEmployeeId());
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
}
