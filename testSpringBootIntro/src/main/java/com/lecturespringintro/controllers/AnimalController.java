package com.lecturespringintro.controllers;

import com.lecturespringintro.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnimalController {

    @Autowired
    private Animal dog;

    @GetMapping("/dog2")
    @ResponseBody
    public String getDog(){
        return dog.getName();
    }
}
