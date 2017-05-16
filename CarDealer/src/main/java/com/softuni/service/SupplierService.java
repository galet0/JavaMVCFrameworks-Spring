package com.softuni.service;


import com.softuni.models.viewModels.suppliers.SupplierNameView;
import com.softuni.models.viewModels.suppliers.SupplierViewModel;

import java.util.List;
import java.util.Set;

public interface SupplierService {

    Set<SupplierViewModel> getAllSuppliers(String filter);

    List<SupplierNameView> getAll();

    SupplierNameView getByName(String name);
}
