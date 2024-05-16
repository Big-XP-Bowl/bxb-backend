package dat3.bxb.diningtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiningTableRepository extends JpaRepository<DiningTable, Integer> {
    DiningTable findById(int id);
    DiningTable findByDiningTableNumber(int diningTableNumber);
}