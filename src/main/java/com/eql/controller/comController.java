package com.eql.controller;


import com.eql.dto.UserDto;
import com.eql.model.Commande;
import com.eql.model.Livreur;
import com.eql.service.CommandeService;
import com.eql.service.LivreurService;
import com.eql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class comController {

    @Autowired
    CommandeService commandeService;
    @Autowired
    LivreurService livreurService;


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

    @GetMapping("/adminCommandes")
    public String commandesList(Model model,@AuthenticationPrincipal UserDetails currentUser) {
        List<Commande> commandes = commandeService.getAll();
        List<Livreur> livreurs = livreurService.getAll();
        Commande commande = new Commande();
        model.addAttribute("commandes", commandes);
        model.addAttribute("livreurs", livreurs);
        model.addAttribute("commande", commande);
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }return "adminCommandes";
    }

    @PostMapping("/dispatch/{id}")
    public String dispatch(@PathVariable(value = "id") Integer id, Model model,
                           @AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        Commande commande = commandeService.getComById(id);
        commandeService.saveCom(commande);
        return "adminCommandes";
    }

}