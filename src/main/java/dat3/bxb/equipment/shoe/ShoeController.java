package dat3.bxb.equipment.shoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoeController {

    @Autowired
    private ShoeService shoeService;

    @GetMapping
    public List<ShoeDTO> getAllShoes() {
        return shoeService.getAllShoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoeDTO> getShoeById(@PathVariable Long id) {
        ShoeDTO shoeDTO = shoeService.getShoeById(id);
        return shoeDTO != null ? ResponseEntity.ok(shoeDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ShoeDTO createShoe(@RequestBody ShoeDTO shoeDTO) {
        return shoeService.createShoe(shoeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoe(@PathVariable Long id) {
        shoeService.deleteShoe(id);
        return ResponseEntity.ok().build();
    }
}

