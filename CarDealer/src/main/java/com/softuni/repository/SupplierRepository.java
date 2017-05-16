package com.softuni.repository;

import com.softuni.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Set<Supplier> getAllByOrderByIdAsc();

    Set<Supplier> getByIsImporter(boolean isImporter);

    Supplier findFirstByName(String name);
}
