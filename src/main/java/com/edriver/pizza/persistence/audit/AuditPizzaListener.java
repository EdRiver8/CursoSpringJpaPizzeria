package com.edriver.pizza.persistence.audit;

import com.edriver.pizza.persistence.entity.PizzaEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.apache.commons.lang3.SerializationUtils;

public class AuditPizzaListener {
    private PizzaEntity currentValue;

    @PostLoad
    public void postLoad(PizzaEntity pizzaEntity){
        System.out.println("POST LOAD");
        this.currentValue = SerializationUtils.clone(pizzaEntity);
    }

    @PostPersist // esta anotacion se debe poner en un metodo que no retorne nada
    @PostUpdate
    public void onPostPersist(PizzaEntity pizzaEntity){
        System.out.println("POST PERSIST OR UOPDATE");
        System.out.println("OLD VALUE:" + this.currentValue);
        System.out.println("NEW VALUE:" + pizzaEntity.toString());
    }

    @PreRemove
    public void onPreDelete(PizzaEntity pizzaEntity){
        System.out.println(pizzaEntity.toString());
    }
}
