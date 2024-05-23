package dat3.bxb.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    @Query("SELECT r FROM Reservation r WHERE r.activity.id = :activityId AND r.startTime = :startTime")
    List<Reservation> findByActivityIdAndStartTime(@Param("activityId") int activityId, @Param("startTime") LocalDateTime startTime);
}