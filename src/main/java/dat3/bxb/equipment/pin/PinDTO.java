package dat3.bxb.equipment.pin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PinDTO {
    private Long id;

    public PinDTO() {
    }

    public PinDTO(Long id) {
        this.id = id;
    }
}