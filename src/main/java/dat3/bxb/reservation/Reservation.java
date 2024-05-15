package dat3.bxb.reservation;

import dat3.bxb.activity.Activity;
import dat3.security.entity.UserWithRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    private LocalDateTime startTime;

    private int partySize;

    @ManyToOne // Correct mapping for userWithRoles
    @JoinColumn(name = "created_by") // Assuming there's a user_id column in the database
    private UserWithRoles userWithRoles;

    private String customerName;

    private String customerPhone;

    @CreationTimestamp
    private java.time.LocalDateTime created;
    @UpdateTimestamp
    private java.time.LocalDateTime edited;

    public Reservation(Activity activity, LocalDateTime startTime, int partySize, UserWithRoles userWithRoles, String customerName, String customerPhone, LocalDateTime created, LocalDateTime edited) {
        this.activity = activity;
        this.startTime = startTime;
        this.partySize = partySize;
        this.userWithRoles = userWithRoles;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.created = created;
        this.edited = edited;
    }

    public Reservation() {
    }
}
