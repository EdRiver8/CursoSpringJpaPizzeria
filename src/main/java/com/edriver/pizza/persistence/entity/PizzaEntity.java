package com.edriver.pizza.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "pizza")
@Getter @Setter @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PizzaEntity extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false) // lanza un excepcion si este atributo es nulo
    private Integer idPizza;
    @Column(nullable = false, length = 30, unique = true)
    private String name;
    @Column(nullable = false, length = 150)
    private String description;
    @Column(nullable = false, columnDefinition = "Decimal(5,2)") // Decimal de 5 numeros, dos de ellos son decimales
    private Double price;
    @Column(columnDefinition = "TINYINT")
    private Boolean vegetarian;
    @Column(columnDefinition = "TINYINT")
    private Boolean vegan;
    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean available;
}
