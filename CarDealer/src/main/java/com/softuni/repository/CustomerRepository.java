package com.softuni.repository;

import com.softuni.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Set<Customer> getAllByOrderByBirthDateAscIsYoungDriverAsc();

    Set<Customer> getAllByOrderByBirthDateDescIsYoungDriverAsc();

    @Modifying
    @Query(value = "UPDATE Customer SET name = :name, birthDate = :birthDate WHERE id = :id")
    void updateCustomer(@Param("name") String name,
                        @Param("birthDate") Date birthDate,
                        @Param("id") long id);
}
