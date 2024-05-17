package dat3.bxb.equipment.shoe;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int size;

    public Shoe() {
    }

    public Shoe(int size) {
        this.size = size;
    }
}