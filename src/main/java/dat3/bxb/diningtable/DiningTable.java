package dat3.bxb.diningtable;

import dat3.bxb.activity.Activity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DiningTable extends Activity {
    private int diningTableNumber;

    public DiningTable(String name, int capacity, boolean isReserved, int duration, boolean isClosed, int DiningTableNumber) {
        super(name, capacity, isReserved, duration, isClosed);
        this.diningTableNumber = DiningTableNumber;
    }

    public DiningTable(){}
}