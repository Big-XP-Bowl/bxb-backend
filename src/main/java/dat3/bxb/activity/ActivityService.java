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
    public ActivityDTO convertToDTO(Activity activity) {
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setId(activity.getId());
        activityDTO.setName(activity.getName());
        activityDTO.setCapacity(activity.getCapacity());
        activityDTO.setDuration(activity.getDuration());
        activityDTO.setIsClosed(activity.isClosed());
        activityDTO.setIsReserved(activity.isReserved());

        // Check if the activity is Airhockey or BowlingLane and set additional fields accordingly
        activityDTO.setType("Airhockey");
        activityDTO.setTableNumber(((Airhockey) activity).getTableNumber());

        return activityDTO;
    }
}
