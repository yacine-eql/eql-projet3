package com.eql.controller;


import com.eql.dto.UserDto;
import com.eql.model.Commande;
import com.eql.service.CommandeService;
import com.eql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class comController {

    @Autowired
    CommandeService commandeService;


    @Autowired
    UserService userService;

    @GetMapping("/allCom")
    public String commandes(Model model,@AuthenticationPrincipal UserDetails currentUser){

        List<Commande> commandes = commandeService.getAll();
        model.addAttribute("commandes",commandes);
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }
        return "space";
    }
}