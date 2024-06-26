package dat3.bxb.equipment.pin;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PinService {
    private final PinRepository pinRepository;

    public PinService(PinRepository pinRepository) {
        this.pinRepository = pinRepository;
    }

    public List<PinDTO> getAllPins() {
        return pinRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PinDTO getPinById(int id) {
        return pinRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public PinDTO createPin(PinDTO pinDTO) {
        Pin pin = convertToEntity(pinDTO);
        pin = pinRepository.save(pin);
        return convertToDTO(pin);
    }

    public void deletePin(int id) {
        pinRepository.deleteById(id);
    }

    private PinDTO convertToDTO(Pin pin) {
        return new PinDTO(pin.getId());
    }

    private Pin convertToEntity(PinDTO pinDTO) {
        Pin pin = new Pin();
        pin.setId(pinDTO.getId());
        return pin;
    }
}