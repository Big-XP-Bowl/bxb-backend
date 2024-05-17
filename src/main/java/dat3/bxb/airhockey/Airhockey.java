package dat3.bxb.airhockey;

import dat3.bxb.activity.Activity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airhockey extends Activity {
    private int tableNumber;

    public Airhockey(String name, int capacity, boolean isReserved, int duration, boolean isClosed, int TableNumber) {
        super(name, capacity, isReserved, duration, isClosed);
        this.tableNumber = TableNumber;
    }
    public Airhockey(){}
}