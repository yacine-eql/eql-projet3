package com.eql.controller;

import com.eql.dto.UserDto;
import com.eql.model.Categorie;
import com.eql.model.Commentaire;
import com.eql.model.Livreur;
import com.eql.model.Produit;
import com.eql.service.CategorieService;
import com.eql.service.ProduitService;
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

import javax.validation.Valid;
import java.util.List;

@Controller
public class prodController {

    @Autowired
    UserService userService;

    @Autowired
    ProduitService produitService;

    @Autowired
    CategorieService categorieService;

    Produit productToDelete;

    @GetMapping("/carte")
    public String products(Model model,@AuthenticationPrincipal UserDetails currentUser){

        model.addAttribute("count",PanierController.count );

        List<Produit> basiques = produitService.getBasiques();
        model.addAttribute("basiques",basiques);

        List<Produit> incontournables = produitService.getIncontournables();
        model.addAttribute("incontournables",incontournables);

        List<Produit> supremes = produitService.getSupremes();
        model.addAttribute("supremes",supremes);

        List<Produit> desserts = produitService.getDesserts();
        model.addAttribute("desserts",desserts);

        List<Produit> boissons = produitService.getBoissons();
        model.addAttribute("boissons",boissons);

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
        model.addAttribute("produit",produitService.getProduitById(id));



        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }
        return "evaluatePage";

    }

    //////////////////////////////////////////////

    @GetMapping("/product")
    public String showProductfrom(Model model,@AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        List<Categorie> categories = categorieService.findAllCategories();
        model.addAttribute("categories",categories);

        Produit produit = new Produit();
        model.addAttribute("produit",produit);
        return  "addProduct";
    }

    @PostMapping("/register/product")
    public String registration(@Valid @ModelAttribute("produit") Produit produit, Model model,
                               @AuthenticationPrincipal UserDetails currentUser){

        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }

        produitService.ajoutroduit(produit);
        return "redirect:/adminProd?success";

    }

    @GetMapping("/updateProduct/{id}")
    public  String  showFormForUpdateLivreur(@PathVariable(value = "id") Integer id, Model model,
                                             @AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        List<Categorie> categories = categorieService.findAllCategories();
        model.addAttribute("categories",categories);

        Produit produit = produitService.getProduitById(id);
        model.addAttribute("produit",produit);
        return "updateProduct";
    }

    @PostMapping("/update/product")
    public String updateProductByAdmin(@ModelAttribute("produit") Produit produit){
        produitService.updateProduct(produit);
        return "redirect:/adminProd?update";
    }

    @GetMapping("/deleteProduct/{id}")
    public  String deleteProduct(@PathVariable(value = "id") Integer id,Model model, @AuthenticationPrincipal UserDetails currentUser ){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        productToDelete = produitService.getProduitById(id);
        return "deletePageProduct";
    }

    @GetMapping("/deleteProduct")
    public  String deleteProductConfirm( ){
        produitService.deleteProduct(productToDelete.getProduitId());
        return "redirect:/adminProd?delete";
    }


}