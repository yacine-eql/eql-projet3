package com.eql.controller;


import com.eql.dto.UserDto;
import com.eql.model.Commande;
import com.eql.model.Livreur;
import com.eql.model.User;
import com.eql.service.CommandeService;
import com.eql.service.LivreurService;
import com.eql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Iterator;
import java.util.List;

@Controller
public class comController {

    @Autowired
    CommandeService commandeService;
    @Autowired
    LivreurService livreurService;

    Commande com;


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
        model.addAttribute("count",PanierController.count );
        return "space";
    }

    @GetMapping("/adminCommandes")
    public String commandesList(Model model,@AuthenticationPrincipal UserDetails currentUser) {
        List<Commande> commandes = commandeService.getAll();

        model.addAttribute("commandes", commandes);

        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }return "adminCommandes";
    }

    @GetMapping("/dispatch/{id}")
    public String dispatch(@PathVariable(value = "id") Integer id,Model model,
                           @AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        Livreur livreur = new Livreur();

        model.addAttribute(livreur);
        Commande commande = commandeService.getComById(id);
        com = commande ;
        model.addAttribute("commande",commande);

        System.out.println(model);
        return "dispatchCommande";
    }


    @PostMapping("/update/commande")
    public String updateLivreurByAdmin(Commande commande,
                                       @ModelAttribute("livreur") Livreur livreur){

        commande.setCommandeId(com.getCommandeId());
        commande.setCommandeDate(com.getCommandeDate());
        commande.setLigneComs(com.getLigneComs());
        commande.setFacture(com.getFacture());
        commande.setLivreur(livreurService.findLivreurByPrenom(livreur.getPrenom()));

        commandeService.saveCom(commande);
        return "redirect:/adminCommandes";
    }

    @GetMapping("/adminComLivre")
    public String commandesLivre(Model model,@AuthenticationPrincipal UserDetails currentUser) {
        List<Commande> commandes = commandeService.getAll();


        for (Iterator<Commande> it = commandes.iterator(); it.hasNext();) {
            Commande s = it.next();

            if (s.getLivreur()== null){
                it.remove();
            }
        }
        model.addAttribute("commandes", commandes);

        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }return "adminComLivre";
    }

    @GetMapping("/adminCom")
    public String com(Model model,@AuthenticationPrincipal UserDetails currentUser) {
        List<Commande> commandes = commandeService.getAll();


        for (Iterator<Commande> it = commandes.iterator(); it.hasNext();) {
            Commande s = it.next();

            if (s.getLivreur()!= null){
                it.remove();
            }
        }
        model.addAttribute("commandes", commandes);

        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }return "adminCom";
    }


}