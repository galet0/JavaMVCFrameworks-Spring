package com.lecturespringintro.entities;

import org.springframework.stereotype.Component;

//@Component
public class Dog implements Animal{

    private String name;

    public Dog() {
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
