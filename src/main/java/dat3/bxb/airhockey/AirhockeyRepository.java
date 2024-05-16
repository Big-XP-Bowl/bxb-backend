package dat3.bxb.airhockey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirhockeyRepository extends JpaRepository<Airhockey, Integer> {
    Airhockey findById(int id);
    Airhockey findByTableNumber(int tableNumber);
}