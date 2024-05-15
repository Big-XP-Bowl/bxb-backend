package dat3.bxb.equipment.shoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoeService {

    @Autowired
    private ShoeRepository shoeRepository;

    public List<ShoeDTO> getAllShoes() {
        return shoeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ShoeDTO getShoeById(Long id) {
        return shoeRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public ShoeDTO createShoe(ShoeDTO shoeDTO) {
        Shoe shoe = convertToEntity(shoeDTO);
        shoe = shoeRepository.save(shoe);
        return convertToDTO(shoe);
    }

    public void deleteShoe(Long id) {
        shoeRepository.deleteById(id);
    }

    private ShoeDTO convertToDTO(Shoe shoe) {
        return new ShoeDTO(shoe.getId(), shoe.getSize());
    }

    private Shoe convertToEntity(ShoeDTO shoeDTO) {
        return new Shoe(shoeDTO.getSize());
    }
}
