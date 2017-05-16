package com.springsecuritydemo.service;


import com.springsecuritydemo.models.RegisterModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

    void register(RegisterModel registerModel);

    @PreAuthorize("hasRole('ADMIN')") //като цъкнеш на метода delete той няма да се изпълни, т.е. ще ти каже, че нямаш достъп преди да се изпълни
    //@PostAuthorize -а при него обратното - първо ще се изпълни и тогава ще ти каже, че нямаш достъп
    void delete();
}
