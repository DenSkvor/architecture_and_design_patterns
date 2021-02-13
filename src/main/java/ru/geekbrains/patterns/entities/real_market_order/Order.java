package ru.geekbrains.patterns.entities.real_market_order;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_tbl")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private Integer price;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public Order(Client client, String phoneNumber, String address, Integer price, List<OrderItem> orderItems){
        this.client = client;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.price = price;
        this.orderItems = orderItems;

        for (OrderItem oi:orderItems) {
            oi.setOrder(this);
        }
    }

}
