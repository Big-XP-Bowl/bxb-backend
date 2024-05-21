package dat3.bxb.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter


public class ReservationDTO {
    private int id;
    private int activityID;
    private LocalDateTime startTime;
    private int partySize;
    private String userWithRolesUsername;
    private String customerName;
    private String customerPhone;
    private LocalDateTime created;
    private LocalDateTime edited;


    public void setActivityId(int id) {
        this.activityID = id;
    }
    public Integer getActivityId() {
        return activityID;
    }
}
