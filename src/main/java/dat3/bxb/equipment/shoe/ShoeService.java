package dat3.bxb.equipment.shoe;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoeService {
    private final ShoeRepository shoeRepository;

    public ShoeService(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    public List<ShoeDTO> getAllShoes() {
        return shoeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ShoeDTO getShoeById(int id) {
        return shoeRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public ShoeDTO createShoe(ShoeDTO shoeDTO) {
        Shoe shoe = convertToEntity(shoeDTO);
        shoe = shoeRepository.save(shoe);
        return convertToDTO(shoe);
    }

    public void deleteShoe(int id) {
        shoeRepository.deleteById(id);
    }

    private ShoeDTO convertToDTO(Shoe shoe) {
        return new ShoeDTO(shoe.getId(), shoe.getSize());
    }

    private Shoe convertToEntity(ShoeDTO shoeDTO) {
        return new Shoe(shoeDTO.getSize());
    }
}