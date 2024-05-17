package dat3.bxb.schedule;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ScheduleDTO getScheduleById(@PathVariable int id) {
        return scheduleService.getScheduleById(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getSchedulesByEmployeeId(@PathVariable int employeeId) {
        return scheduleService.getSchedulesByEmployeeId(employeeId);
    }

    @PostMapping("/create")
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.createSchedule(scheduleDTO);
    }

    @PatchMapping("/{id}")
    public ScheduleDTO updateSchedule(@PathVariable int id, @RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.updateSchedule(id, scheduleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable int id) {
        scheduleService.deleteSchedule(id);
    }
}