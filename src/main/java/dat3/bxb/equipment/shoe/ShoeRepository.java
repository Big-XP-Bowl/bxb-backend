package dat3.bxb.equipment.shoe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoeRepository extends JpaRepository<Shoe, Integer> {
    List<Shoe> findBySize(int size);
}
