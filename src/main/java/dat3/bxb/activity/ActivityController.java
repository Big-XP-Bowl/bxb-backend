package dat3.bxb.activity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<ActivityDTO > getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/id/{id}")
    public ActivityDTO getActivityById(@PathVariable int id) {
        return activityService.getActivityById(id);
    }

    @GetMapping("/type/{activityType}")
    public List<ActivityDTO> getActivitiesByType(@PathVariable String activityType) {
        return activityService.getActivitiesByType(activityType);
    }

    @PatchMapping ("/{id}")
    public ActivityDTO updateActivity(@PathVariable int id, @RequestBody ActivityDTO activity) {
        return activityService.updateActivity(id, activity);
    }
}