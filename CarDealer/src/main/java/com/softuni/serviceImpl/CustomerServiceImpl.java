package com.softuni.serviceImpl;

import com.softuni.entities.Customer;
import com.softuni.models.bindingModels.customers.AddCustomerModel;
import com.softuni.models.bindingModels.customers.EditCustomerModel;
import com.softuni.models.viewModels.customers.CustomerDetailsView;
import com.softuni.models.viewModels.customers.CustomerViewModel;
import com.softuni.repository.CustomerRepository;
import com.softuni.service.CustomerService;
import com.softuni.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(AddCustomerModel addCustomerModel) {
        Customer customer = this.modelParser.convert(addCustomerModel, Customer.class);
        this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public Set<CustomerViewModel> getAllOrderedByBirthDate(String type) {
        Set<Customer> customers = new HashSet<>();
        if("Descending".equals(type)){
            customers = this.customerRepository.getAllByOrderByBirthDateDescIsYoungDriverAsc();
        } else {
            customers = this.customerRepository.getAllByOrderByBirthDateAscIsYoungDriverAsc();
        }

        Set<CustomerViewModel> customerViewModels = new HashSet<>();
        for (Customer customer : customers) {
            CustomerViewModel customerViewModel = this.modelParser.convert(customer, CustomerViewModel.class);
            customerViewModels.add(customerViewModel);
        }
        return customerViewModels;
    }

    @Override
    public CustomerDetailsView getById(long id) {
        Customer customer = this.customerRepository.findOne(id);
        CustomerDetailsView customerDetailsView = this.modelParser.convert(customer, CustomerDetailsView.class);
        Double[] totalSum = {0D};
        customer.getSales()
                .forEach(s -> s.getCar().getParts().stream()
                                                    .forEach(p -> totalSum[0] += p.getPrice()));
        customerDetailsView.setTotalSum(totalSum[0]);
        return customerDetailsView;
    }

    @Override
    public EditCustomerModel getByIdToEdit(long id) {
        Customer customer = this.customerRepository.findOne(id);
        EditCustomerModel editCustomerModel = this.modelParser.convert(customer, EditCustomerModel.class);
        return editCustomerModel;
    }

    @Override
    public void updateCustomer(String name, Date birthDate, long id) {
        this.customerRepository.updateCustomer(name, birthDate, id);
    }


}
