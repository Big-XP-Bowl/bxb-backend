package dat3.bxb.activity;

import dat3.bxb.airhockey.Airhockey;
import dat3.bxb.bowlinglane.BowlingLane;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<ActivityDTO> getAllActivities(){
        List<Activity> activities = activityRepository.findAll();
        return activities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ActivityDTO getActivityById(int id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Activity not found with ID: " + id));
        return convertToDTO(activity);
    }

    public List<ActivityDTO> getActivitiesByType(String activityType) {
        List<Activity> activities = activityRepository.findByType(activityType);
        return activities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ActivityDTO convertToDTO(Activity activity) {
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setId(activity.getId());
        activityDTO.setName(activity.getName());
        activityDTO.setCapacity(activity.getCapacity());
        activityDTO.setDuration(activity.getDuration());
        activityDTO.setIsClosed(activity.isClosed());
        activityDTO.setIsReserved(activity.isReserved());

        // Check if the activity is Airhockey or BowlingLane and set additional fields accordingly
        if (activity instanceof Airhockey) {
            activityDTO.setType("Airhockey");
            activityDTO.setTableNumber(((Airhockey) activity).getTableNumber());
        } else if (activity instanceof BowlingLane) {
            activityDTO.setType("BowlingLane");
            activityDTO.setLaneNumber(((BowlingLane) activity).getLaneNumber());
        }

        return activityDTO;
    }
}
