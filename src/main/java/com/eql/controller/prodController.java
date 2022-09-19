package com.eql.controller;

import com.eql.dto.UserDto;
import com.eql.model.Produit;
import com.eql.service.ProduitService;
import com.eql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class prodController {

    @Autowired
    UserService userService;

    @Autowired
    ProduitService produitService;

    @GetMapping("/carte")
    public String products(Model model,Model model1,@AuthenticationPrincipal UserDetails currentUser){

        List<Produit> carte = produitService.getAllProduct();
        model.addAttribute("carte",carte);
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model1.addAttribute("connectedUser", userDto);

    }
        return "carte";
}
}