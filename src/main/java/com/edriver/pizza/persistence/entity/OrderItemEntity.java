package com.edriver.pizza.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class) // permite usar PK compuesta
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {
    @Id // llave compuesta
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;
    @Id // llave compuesta
    @Column(name = "id_item", nullable = false)
    private Integer idItem;
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;
    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private Double quantity;
    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @OneToOne
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", updatable = false, insertable = false)
    private PizzaEntity pizza;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", updatable = false, insertable = false)
    @JsonIgnore
    private OrderEntity order;

}
