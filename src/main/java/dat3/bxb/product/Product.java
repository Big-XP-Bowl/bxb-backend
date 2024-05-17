package dat3.bxb.product;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private Category category; // Drink or Snack

    public Product(Category category, String imageUrl, double price, String name) {
        this.category = category;
        this.imageUrl = imageUrl;
        this.price = price;
        this.name = name;
    }

    public Product() {
    }

    public enum Category {
        DRINK, SNACK
    }
}