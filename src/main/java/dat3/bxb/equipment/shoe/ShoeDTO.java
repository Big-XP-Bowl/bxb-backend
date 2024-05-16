package dat3.bxb.equipment.shoe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoeDTO {
    private Long id;
    private int size;

    public ShoeDTO() {
    }

    public ShoeDTO(Long id, int size) {
        this.id = id;
        this.size = size;
    }
}
