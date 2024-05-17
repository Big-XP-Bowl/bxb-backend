package dat3.bxb.equipment.shoe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoeController {
    private final ShoeService shoeService;

    public ShoeController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @GetMapping
    public List<ShoeDTO> getAllShoes() {
        return shoeService.getAllShoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoeDTO> getShoeById(@PathVariable int id) {
        ShoeDTO shoeDTO = shoeService.getShoeById(id);
        return shoeDTO != null ? ResponseEntity.ok(shoeDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ShoeDTO createShoe(@RequestBody ShoeDTO shoeDTO) {
        return shoeService.createShoe(shoeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoe(@PathVariable int id) {
        shoeService.deleteShoe(id);
        return ResponseEntity.ok().build();
    }
}