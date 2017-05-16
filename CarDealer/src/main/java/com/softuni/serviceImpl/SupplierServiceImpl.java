package com.softuni.serviceImpl;

import com.softuni.entities.Supplier;
import com.softuni.models.viewModels.suppliers.SupplierNameView;
import com.softuni.models.viewModels.suppliers.SupplierViewModel;
import com.softuni.repository.SupplierRepository;
import com.softuni.service.SupplierService;
import com.softuni.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public Set<SupplierViewModel> getAllSuppliers(String filter) {
        Set<Supplier> suppliers = new HashSet<>();
        boolean importer = "Importer".equals(filter);
        if("All Suppliers".equals(filter) || filter == null){
            suppliers = this.supplierRepository.getAllByOrderByIdAsc();
        } else {
            suppliers = this.supplierRepository.getByIsImporter(importer);
        }
        Set<SupplierViewModel> supplierViewModels = new HashSet<>();
        for (Supplier supplier : suppliers) {
            SupplierViewModel supplierViewModel = this.modelParser.convert(supplier, SupplierViewModel.class);
            supplierViewModels.add(supplierViewModel);
        }
        return supplierViewModels;
    }

    @Override
    public List<SupplierNameView> getAll() {
        List<Supplier> suppliers = this.supplierRepository.findAll();
        List<SupplierNameView> supplierNameViews = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            SupplierNameView supplierNameView = this.modelParser.convert(supplier, SupplierNameView.class);
            supplierNameViews.add(supplierNameView);
        }
        return supplierNameViews;
    }

    @Override
    public SupplierNameView getByName(String name) {
        Supplier supplier = this.supplierRepository.findFirstByName(name);
        SupplierNameView supplierNameView = this.modelParser.convert(supplier, SupplierNameView.class);
        return supplierNameView;
    }
}
