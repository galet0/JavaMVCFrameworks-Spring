package com.lecturespringintro.controllers;

import com.lecturespringintro.entities.Cat;
import com.lecturespringintro.models.CatModel;
import com.lecturespringintro.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/cat")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping("/cat")
    public String getCatPage(){
        return "cat-page.html";
    }

// With @RequestParam String name, int age
//    @PostMapping("")
//    public String buyCat(@RequestParam String name, int age){
//        System.out.println("Name: " + name);
//        System.out.println("Age: " + age);
//
//        return "redirect:/";
//    }


//With @ModelAttribute Cat cat
    @PostMapping("/cat")
    public String buyCat(@ModelAttribute CatModel cat){
        System.out.println("Name: " + cat.getName());
        System.out.println("Age: " + cat.getAge());
        this.catService.buy(cat);
        return "redirect:/";
    }

    @GetMapping("/cat/edit/{id}")
    @ResponseBody
    public String getEdit(@PathVariable long id){
        return String.valueOf(id);
    }

    @GetMapping("/myCat")
    public ModelAndView getCat(ModelAndView modelAndView, Model model){
        String cat = "cat";
        model.addAttribute("cat", cat);
        modelAndView.addObject("cat", cat);
        modelAndView.setViewName("cat-page.html");
        return modelAndView;
    }
}
