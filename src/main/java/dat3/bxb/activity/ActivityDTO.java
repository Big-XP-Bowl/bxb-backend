package dat3.bxb.activity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActivityDTO {
    private int id;
    private String name;
    private int capacity;
    private int duration;
    private boolean isClosed;
    private boolean isReserved;
    private String type;
    private int tableNumber;
    private int laneNumber;
    private int diningTableNumber;

    public void setIsClosed(boolean closed) {
        this.isClosed = closed;
    }
}