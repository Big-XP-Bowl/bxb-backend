package dat3.bxb.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByEmployee_Id(int employeeId);
    boolean existsByEmployee_IdAndStartTime(int employeeId, LocalDateTime startTime);
    List<Schedule> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}