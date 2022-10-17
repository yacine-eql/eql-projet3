package com.eql.controller;


import com.eql.dto.UserDto;
import com.eql.model.*;
import com.eql.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class comController {

    @Autowired
    CommandeService commandeService;
    @Autowired
    LivreurService livreurService;

    @Autowired
    ProduitService produitService;

    @Autowired
    CommentaireService commentaireService;
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
        List<Livreur> livreurs = livreurService.getAll();

        model.addAttribute(livreur);
        Commande commande = commandeService.getComById(id);
        com = commande ;
        model.addAttribute("commande",commande);
        model.addAttribute("livreurs",livreurs);

        System.out.println(model);
        return "dispatchCommande";
    }


    @PostMapping("/update/commande")
    public String updateLivreurByAdmin(Commande commande,
                                       @ModelAttribute("livreur") Livreur livreur){

        commande.setUser(com.getUser());
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


    @GetMapping("/evaluateCommande/{id}")
    public String evaluateCommande(@PathVariable(value = "id") Integer id,Model model,@AuthenticationPrincipal UserDetails currentUser) {
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }
        List<LigneCom> ligneComs = commandeService.getComById(id).getLigneComs();
        List<Produit> produits = new ArrayList<>();
        for (LigneCom ligneCom : ligneComs) {
            produits.add(ligneCom.getProduit());
        }

        com = commandeService.getComById(id);
        model.addAttribute("produits", produits);


        return "evaluateCommande";
    }

    @GetMapping("/evaluateProduit/{id}")
    public String evaluateProduit(@PathVariable(value = "id") Integer id,Model model,
                                  @AuthenticationPrincipal UserDetails currentUser) {
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }

        Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String s = formatter.format(com.getCommandeDate());
        UserDto user =new UserDto();
        user.setEmail(s);

        user.setFirstName(produitService.getProduitById(id).getLabel());
        model.addAttribute("user",user);


        return "evaluateProduit";
    }
    @PostMapping("/eval")
    public String evaluate(Model model,UserDto userDto1, @AuthenticationPrincipal UserDetails currentUser){


        model.addAttribute("user", userDto1);


        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }
        Commentaire commentaire = new Commentaire();
        commentaire.setDateEval(new Date());
        commentaire.setDateCom(com.getCommandeDate());
        commentaire.setProduit(produitService.getProduitByLabel(userDto1.getFirstName()));
        commentaire.setEvaluation(userDto1.getAddress());
        commentaireService.addCommentaire(commentaire);

        return "redirect:/space?evaluate";
    }

    @GetMapping("/confirmationLivreur")
    public String home(Model model){

        model.addAttribute("count",PanierController.count );
        return "confirmationLivreur";
    }
}