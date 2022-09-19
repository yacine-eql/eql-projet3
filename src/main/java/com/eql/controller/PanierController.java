package com.eql.controller;


import com.eql.dto.UserDto;
import com.eql.model.Produit;
import com.eql.model.User;
import com.eql.service.CommandeService;
import com.eql.service.ProduitService;
import com.eql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PanierController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommandeService commandeService;

    @GetMapping("/addToCart/{id}")
    public  String addToCart(@PathVariable(value = "id") int id, HttpServletRequest request){
       HttpSession session = request.getSession();

        Map<Produit,Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
        Double total = (Double) session.getAttribute("total");

        if (panier == null){

            total=0.0;
            panier = new HashMap<Produit, Integer>();
            Produit produit = produitService.getProduitById(id);
            panier.put(produit, 1);
            session.setAttribute("panier",panier);
            total = produit.getPrix();
            session.setAttribute("total",total);

        } else {
            Produit produit = produitService.getProduitById(id);
            if (panier.containsKey(produit)){

                panier.put(produit, panier.get(produit) + 1);
                session.setAttribute("panier",panier);
                total += produit.getPrix();
                session.setAttribute("total",total);

                for (Produit key: panier.keySet()) {
                    System.out.println(key + "=" + panier.get(key));
                }

            }else {
                panier.put(produit,1);
                session.setAttribute("panier",panier);
                total += produit.getPrix();
                session.setAttribute("total",total);

                for (Produit key: panier.keySet()) {
                    System.out.println(key + "=" + panier.get(key));
                }
            }

        }
        return "redirect:/carte";
    }

    @GetMapping("/voirPanier")
    public String voirPanier(HttpServletRequest request, Model model,@AuthenticationPrincipal UserDetails currentUser){

        HttpSession session = request.getSession();
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        Map<Produit,Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
        Double total = (Double) session.getAttribute("total");
        if (panier == null) {
            total = 0.0;
        }


        System.out.println("voir : "+panier);
        model.addAttribute("produits",panier);
        model.addAttribute("total",total);

        return "panier";
    }

    @PostMapping("/validePanier")
    public String validePanier(HttpServletRequest request, Model model,@AuthenticationPrincipal UserDetails currentUser){
        HttpSession session = request.getSession();
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        User user = userService.findUserByEmail(currentUser.getUsername());
        Map<Produit,Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
        Double total = (Double) session.getAttribute("total");
        model.addAttribute("produits",panier);
        model.addAttribute("total",total);
        commandeService.ajoueCommande(user,total,panier);

        return "redirect:/space?success";
    }

    @GetMapping("/add/{id}")
    public  String addCart(@PathVariable(value = "id") int id,Model model, HttpServletRequest request,
                           @AuthenticationPrincipal UserDetails currentUser){
        HttpSession session = request.getSession();
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }

        Map<Produit,Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
        Double total = (Double) session.getAttribute("total");


        Produit produit = produitService.getProduitById(id);
        panier.put(produit, panier.get(produit) + 1);
        session.setAttribute("panier",panier);
        total += produit.getPrix();
        session.setAttribute("total",total);


        return "redirect:/voirPanier";
    }
    @GetMapping("/sous/{id}")
    public  String sousCart(@PathVariable(value = "id") int id,Model model, HttpServletRequest request,
                            @AuthenticationPrincipal UserDetails currentUser){
        HttpSession session = request.getSession();
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }


        Map<Produit,Integer> panier = (Map<Produit, Integer>) session.getAttribute("panier");
        Double total = (Double) session.getAttribute("total");


        Produit produit = produitService.getProduitById(id);
        if (panier.get(produit)>1){

            panier.put(produit, panier.get(produit) - 1);
            session.setAttribute("panier",panier);
            total -= produit.getPrix();
            session.setAttribute("total",total);

        }else {
            panier.remove(produit);
            session.setAttribute("panier",panier);
            total -= produit.getPrix();
            session.setAttribute("total",total);

        }
        return "redirect:/voirPanier";
    }



}
