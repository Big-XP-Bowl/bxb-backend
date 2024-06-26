package dat3.bxb.bowlinglane;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BowlingLaneRepository extends JpaRepository<BowlingLane, Integer>{
    BowlingLane findById(int id);
    BowlingLane findByLaneNumber(int laneNumber);
}