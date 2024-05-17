package dat3.bxb.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    @Query(value = "SELECT * FROM Activity WHERE dtype = :activityType", nativeQuery = true)
    List<Activity> findByType(@Param("activityType") String activityType);
}