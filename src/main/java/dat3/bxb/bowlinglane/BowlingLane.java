package dat3.bxb.bowlinglane;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import dat3.bxb.activity.Activity;

@Entity
@Getter
@Setter
public class BowlingLane extends Activity {
    private int laneNumber;
    private boolean isChildFriendly;

    public BowlingLane(String name, int capacity, boolean isReserved, int duration, boolean isClosed, int laneNumber, boolean isChildFriendly) {
        super(name, capacity, isReserved, duration, isClosed);
        this.laneNumber = laneNumber;
        this.isChildFriendly = isChildFriendly;
    }
    public BowlingLane(){}
}
