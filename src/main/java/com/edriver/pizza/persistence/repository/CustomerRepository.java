package com.edriver.pizza.persistence.repository;

import com.edriver.pizza.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String> {
    // Queries usando JPQL, este es muy similar a los SQL Nativos =>
    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.phoneNumber = :phone")// ':phone' se tiene el parametro con ese nombre
    CustomerEntity findByPhoneNumber(@Param("phone") String phone);

}
