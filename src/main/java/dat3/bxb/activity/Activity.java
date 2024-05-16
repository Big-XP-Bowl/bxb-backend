package dat3.bxb.activity;

import dat3.bxb.reservation.Reservation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Entity
public class Activity {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int capacity;
    private boolean isReserved;
    private int duration;
    private boolean isClosed;

    //constructors
    public Activity(String name, int capacity, boolean isReserved, int duration, boolean isClosed) {
        this.name = name;
        this.capacity = capacity;
        this.isReserved = isReserved;
        this.duration = duration;
        this.isClosed = isClosed;
    }
    public Activity(String name, int capacity, int duration) {
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
    }
    public Activity(){}
}
