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

    public BowlingLane(String name, int capacity, boolean isReserved, int duration, boolean isClosed, int LaneNumber) {
        super(name, capacity, isReserved, duration, isClosed);
        this.laneNumber = LaneNumber;
    }
    public BowlingLane(){}
}
