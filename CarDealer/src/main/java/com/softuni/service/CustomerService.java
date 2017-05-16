package com.softuni.service;


import com.softuni.models.bindingModels.customers.AddCustomerModel;
import com.softuni.models.bindingModels.customers.EditCustomerModel;
import com.softuni.models.viewModels.customers.CustomerDetailsView;
import com.softuni.models.viewModels.customers.CustomerViewModel;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface CustomerService {

    void create(AddCustomerModel addCustomerModel);

    Set<CustomerViewModel> getAllOrderedByBirthDate(String type);

    CustomerDetailsView getById(long id);

    EditCustomerModel getByIdToEdit(long id);

    void updateCustomer(String name, Date birthDate, long id);
}
