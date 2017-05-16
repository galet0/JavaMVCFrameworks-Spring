package softuni.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import softuni.User;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model, HttpSession session){
        //model.addAttribute("name", "Pesho");
        session.setAttribute("name","Pesho");
        return "variableexpressions";
    }

    //return String
    @GetMapping("/stringuser")
    public String getUser(Model model){
        User user = new User(35L, "Pesho");
        model.addAttribute("user", user);
        return "selectionexpressions";
    }

    //return ModelAndView
    @GetMapping("/mavuser")
    public ModelAndView getUser(){
        User user = new User(40L,"Ivan");
        ModelAndView modelAndView = new ModelAndView("selectionexpressions");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/linkexpr")
    public String getLinkExpr(){
        return "linkexpressions";
    }

    @GetMapping("/helloid")
    public String printId(Model model){
        model.addAttribute("id", 5);
        return "linkexpressions";
    }

    @GetMapping("/buy/{id}")
    public String getUserId(@PathVariable("id") long id){
        System.out.println(id);
        return "redirect:/hello";
    }
}
