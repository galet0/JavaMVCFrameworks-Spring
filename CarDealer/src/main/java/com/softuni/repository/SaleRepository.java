package com.softuni.repository;

import com.softuni.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAllByDiscount(double discount);

    @Query(value = "SELECT s FROM Sale AS s WHERE s.discount > 0")
    List<Sale> findAllWhereDiscountIsNotNull();
}

