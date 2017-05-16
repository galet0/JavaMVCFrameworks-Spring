package com.softuni.service;

import com.softuni.models.bindingModels.parts.PartModel;
import com.softuni.models.bindingModels.parts.PartNameModel;
import com.softuni.models.viewModels.parts.PartDetailModel;
import com.softuni.models.viewModels.parts.PartViewModel;

import java.util.List;
import java.util.Set;

public interface PartService {

    Set<PartViewModel> getAllParts();

    Set<PartDetailModel> getAll();

    void create(PartModel modifiablePartModel);

    PartDetailModel getPartById(long id);

    PartModel getByIdToEdit(long id);

    void updatePart(double price, long quantity, long id);

    void delete(PartModel addPartModel);

    PartNameModel getByName(String name);
}
