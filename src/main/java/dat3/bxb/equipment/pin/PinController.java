package dat3.bxb.equipment.pin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pins")
public class PinController {
    private final PinService pinService;

    public PinController(PinService pinService) {
        this.pinService = pinService;
    }

    @GetMapping
    public List<PinDTO> getAllPins() {
        return pinService.getAllPins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PinDTO> getPinById(@PathVariable Long id) {
        PinDTO pinDTO = pinService.getPinById(id);
        return pinDTO != null ? ResponseEntity.ok(pinDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public PinDTO createPin(@RequestBody PinDTO pinDTO) {
        return pinService.createPin(pinDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePin(@PathVariable Long id) {
        pinService.deletePin(id);
        return ResponseEntity.ok().build();
    }
}
