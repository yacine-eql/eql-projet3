package com.eql.controller;

import com.eql.dto.UserDto;
import com.eql.model.Commentaire;
import com.eql.model.Produit;
import com.eql.service.ProduitService;
import com.eql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class prodController {

    @Autowired
    UserService userService;

    @Autowired
    ProduitService produitService;

    @GetMapping("/carte")
    public String products(Model model,@AuthenticationPrincipal UserDetails currentUser){

        model.addAttribute("count",PanierController.count );

        List<Produit> basiques = produitService.getBasiques();
        model.addAttribute("basiques",basiques);

        List<Produit> incontournables = produitService.getIncontournables();
        model.addAttribute("incontournables",incontournables);

        List<Produit> supremes = produitService.getSupremes();
        model.addAttribute("supremes",supremes);

        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

    }
        return "carte";

}
    @GetMapping("/evaluatePage/{id}")
    public String eval(@PathVariable(value = "id") Integer id,Model model, @AuthenticationPrincipal UserDetails currentUser){

        model.addAttribute("count",PanierController.count );

        List<Commentaire> commentaires = produitService.getProduitById(id).getCommentaires();
        model.addAttribute("commentaires",commentaires);



        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }
        return "evaluatePage";

    }


}