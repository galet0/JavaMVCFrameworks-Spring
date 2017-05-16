package com.softuni.repository;

import com.softuni.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

    Set<Part> findAllByOrderByName();

    @Modifying
    @Query(value = "UPDATE Part SET price = :price, quantity = :quantity WHERE id = :id")
    void updatePart(@Param("price") double price,
                    @Param("quantity") long quantity,
                    @Param("id") long id);

    Part findByName(String name);
}
