package dat3.bxb.product;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String name;
    private double price;
    private String imageUrl;
    private Product.Category category;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, double price, String imageUrl, Product.Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }
}
