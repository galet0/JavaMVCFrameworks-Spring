package com.softuni.serviceImpl;

import com.softuni.entities.Part;
import com.softuni.models.bindingModels.parts.PartModel;
import com.softuni.models.bindingModels.parts.PartNameModel;
import com.softuni.models.viewModels.parts.PartDetailModel;
import com.softuni.models.viewModels.parts.PartViewModel;
import com.softuni.repository.PartRepository;
import com.softuni.service.PartService;
import com.softuni.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PartServiceImpl implements PartService {

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public Set<PartViewModel> getAllParts() {
        Set<Part> parts = this.partRepository.findAllByOrderByName();
        Set<PartViewModel> partViewModels = new HashSet<>();
        for (Part part : parts) {
            PartViewModel partViewModel = this.modelParser.convert(part, PartViewModel.class);
            partViewModels.add(partViewModel);
        }
        return partViewModels;
    }

    @Override
    public Set<PartDetailModel> getAll() {
        Set<Part> parts = this.partRepository.findAllByOrderByName();
        Set<PartDetailModel> partViewModels = new HashSet<>();
        for (Part part : parts) {
            PartDetailModel partViewModel = this.modelParser.convert(part, PartDetailModel.class);
            partViewModels.add(partViewModel);
        }
        return partViewModels;
    }

    @Override
    public void create(PartModel modifiablePartModel) {
        Part part = this.modelParser.convert(modifiablePartModel, Part.class);
        this.partRepository.saveAndFlush(part);
    }

    @Override
    public PartDetailModel getPartById(long id) {
        Part part = this.partRepository.findOne(id);
        PartDetailModel partDetailModel = this.modelParser.convert(part, PartDetailModel.class);
        return partDetailModel;
    }

    @Override
    public PartModel getByIdToEdit(long id) {
        Part part = this.partRepository.findOne(id);
        PartModel modifiablePartModel = this.modelParser.convert(part, PartModel.class);
        return modifiablePartModel;
    }

    @Override
    public void updatePart(double price, long quantity, long id) {
        this.partRepository.updatePart(price, quantity, id);
    }

    @Override
    public void delete(PartModel addPartModel) {
        this.partRepository.delete(addPartModel.getId());
    }

    @Override
    public PartNameModel getByName(String name) {
        Part part = this.partRepository.findByName(name);
        PartNameModel partDetailModel = this.modelParser.convert(part, PartNameModel.class);
        return partDetailModel;
    }
}
