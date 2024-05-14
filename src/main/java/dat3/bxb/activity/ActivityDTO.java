package dat3.bxb.activity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActivityDTO {
    int id;
    String name;
    int capacity;
    boolean isReserved;
    int duration;
    boolean isClosed;
    int laneNumber;
    int tableNumber;
    String type;

    public void setIsClosed(boolean closed) {
    }

    public void setIsReserved(boolean reserved) {
    }
}
