package com.softuni.serviceImpl;

import com.softuni.entities.Sale;
import com.softuni.models.viewModels.sales.SaleDetailsView;
import com.softuni.models.viewModels.sales.SaleView;
import com.softuni.models.viewModels.sales.SaleWithCarMakeAndCustomerView;
import com.softuni.repository.SaleRepository;
import com.softuni.service.SaleService;
import com.softuni.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public List<SaleWithCarMakeAndCustomerView> getAllSales() {
        List<Sale> sales = this.saleRepository.findAll();
        List<SaleWithCarMakeAndCustomerView> saleViews = new ArrayList<>();
        for (Sale sale : sales) {
            SaleWithCarMakeAndCustomerView saleView = this.modelParser.convert(sale, SaleWithCarMakeAndCustomerView.class);
            saleViews.add(saleView);
        }
        return saleViews;
    }

    @Override
    public SaleDetailsView findById(long id) {
        Sale sale = this.saleRepository.findOne(id);
        SaleDetailsView saleDetailsView = this.modelParser.convert(sale, SaleDetailsView.class);
        return saleDetailsView;
    }

    @Override
    public List<SaleView> getAll() {
        List<Sale> sales = this.saleRepository.findAll();
        List<SaleView> saleViews = new ArrayList<>();
        for (Sale sale : sales) {
            SaleView saleView = this.modelParser.convert(sale, SaleView.class);
            saleViews.add(saleView);
        }
        return saleViews;
    }

    @Override
    public List<SaleView> getAllWithDiscount() {
        List<Sale> sales = this.saleRepository.findAllWhereDiscountIsNotNull();
        List<SaleView> saleViews = new ArrayList<>();
        for (Sale sale : sales) {
            SaleView saleView = this.modelParser.convert(sale, SaleView.class);
            saleViews.add(saleView);
        }
        return saleViews;
    }

    @Override
    public List<SaleView> getAllByDiscount(double discount) {
        List<Sale> sales = this.saleRepository.findAllByDiscount(discount);
        List<SaleView> saleViews = new ArrayList<>();
        for (Sale sale : sales) {
            SaleView saleView = this.modelParser.convert(sale, SaleView.class);
            saleViews.add(saleView);
        }
        return saleViews;
    }
}
