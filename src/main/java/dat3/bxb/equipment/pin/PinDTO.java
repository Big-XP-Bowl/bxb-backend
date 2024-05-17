package dat3.bxb.equipment.pin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PinDTO {
    private int id;

    public PinDTO() {
    }

    public PinDTO(int id) {
        this.id = id;
    }
}