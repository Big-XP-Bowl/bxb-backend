package dat3.bxb.reservation;

import dat3.bxb.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    Optional<Reservation> findByActivityAndStartTime(Activity activity, LocalDateTime startTime);
}
