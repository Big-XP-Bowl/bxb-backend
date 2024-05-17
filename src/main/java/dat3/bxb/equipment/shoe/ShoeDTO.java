package dat3.bxb.equipment.shoe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoeDTO {
    private int id;
    private int size;

    public ShoeDTO() {
    }

    public ShoeDTO(int id, int size) {
        this.id = id;
        this.size = size;
    }
}
