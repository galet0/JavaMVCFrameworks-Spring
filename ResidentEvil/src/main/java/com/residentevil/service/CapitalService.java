package com.residentevil.service;


import com.residentevil.entities.Capital;
import com.residentevil.models.viewModels.CapitalView;

import java.util.List;
import java.util.Set;

public interface CapitalService {

    List<String> getCapitals();

    Set<CapitalView> getAllByNameIn(String[] names);
}
