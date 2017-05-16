package com.residentevil.serviceImpl;

import com.residentevil.entities.Capital;
import com.residentevil.models.viewModels.CapitalView;
import com.residentevil.repository.CapitalRepository;
import com.residentevil.service.CapitalService;
import com.residentevil.utils.ModelParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CapitalServiceImpl implements CapitalService {

    private final CapitalRepository capitalRepository;

    private final ModelParser modelParser;

    @Autowired
    public CapitalServiceImpl(CapitalRepository capitalRepository, ModelParser modelParser) {
        this.capitalRepository = capitalRepository;
        this.modelParser = modelParser;
    }

    @Override
    public List<String> getCapitals() {
        List<String> capitals = this.capitalRepository.getCapitalNames();
        return capitals;
    }

    @Override
    public Set<CapitalView> getAllByNameIn(String[] names) {
        Set<Capital> capitals = this.capitalRepository.getAllByNameIn(names);
        Set<CapitalView> capitalViews = new HashSet<>();
        for (Capital capital : capitals) {
            CapitalView capitalView = this.modelParser.convert(capital, CapitalView.class);
            capitalViews.add(capitalView);
        }
        return capitalViews;
    }

}
