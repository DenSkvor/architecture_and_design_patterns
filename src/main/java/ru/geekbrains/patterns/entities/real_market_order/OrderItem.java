package ru.geekbrains.patterns.entities.real_market_order;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_item_tbl")
@Data
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "product_price")
    private Integer productPrice;

    @Column(name = "total_cost")
    private Integer totalCost;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem(Product product){
        this.product = product;
        quantity = 1;
        this.productPrice = product.getPrice();
        totalCost = productPrice;
    }


    public void incrementQuantity() {
        quantity++;
        totalCost = quantity * productPrice;
    }

    public void decrementQuantity() {
        quantity--;
        totalCost = quantity * productPrice;
    }
}
