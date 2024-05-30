package dat3.bxb.activity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Activity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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

    public void setIsClosed(boolean closed) {
        this.isClosed = closed;
    }

    public void setIsOpen(boolean isOpen) {
        this.isClosed = !isOpen;
    }
}