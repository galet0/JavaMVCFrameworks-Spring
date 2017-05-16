package com.lecturespringintro.serviceImpl;

import com.lecturespringintro.entities.Cat;
import com.lecturespringintro.models.CatModel;
import com.lecturespringintro.repositories.CatRepository;
import com.lecturespringintro.service.CatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CatRepository catRepository;

    @Override
    public void buy(CatModel catModel) {
        Cat cat = this.modelMapper.map(catModel, Cat.class);
        this.catRepository.save(cat);
    }
}
