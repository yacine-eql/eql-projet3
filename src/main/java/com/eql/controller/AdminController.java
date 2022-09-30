package com.eql.controller;


import com.eql.dto.UserDto;
import com.eql.model.Livreur;
import com.eql.model.User;
import com.eql.service.CommandeService;
import com.eql.service.LivreurService;
import com.eql.service.ProduitService;
import com.eql.service.UserService;
import com.eql.webServices.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    ProduitService produitService;
    @Autowired
    CommandeService commandeService;
    @Autowired
    LivreurService livreurService;
    @Autowired
    EmailSenderService emailSenderService;

    User userToDelete;
    Livreur livreurTodelete;

    @GetMapping("/updateAccounts/{id}")
    public  String  showFormForUpdate(@PathVariable(value = "id") Long id, Model model,
                                      @AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        UserDto userDto1 = userService.mapToUserDto(userService.findUserById(id));
        model.addAttribute("user",userDto1);
        return "updateTest";
    }

    @PostMapping("/update/admin")
    public String updateUserByAdmin(@ModelAttribute("user") UserDto userDto){
        userService.saveUserUpdate(userDto);
        return "redirect:/adminSpace";
    }

    @GetMapping("/delete/{id}")
    public  String deleteUserByAdmin(@PathVariable(value = "id") Long id,@AuthenticationPrincipal UserDetails currentUser ){
        UserDto userDto = userService.mapToUserDto(userService.findUserById(id));
        userService.deleteUser(userDto.getId());
        return "redirect:/adminSpace?delete";
    }

    @GetMapping("/adminClient")
    public String users(Model model,@AuthenticationPrincipal UserDetails currentUser) {
        List<UserDto> users = userService.findAllNewUsers();

        model.addAttribute("users", users);
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }return "adminClients";
    }

    @GetMapping("/adminTopClients")
    public String topUsers(Model model,@AuthenticationPrincipal UserDetails currentUser) {
        List<UserDto> users = userService.findTopUsers();

        model.addAttribute("users", users);
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);

        }return "adminTopClients";
    }

    @GetMapping("/adminLivreurs")
    public String livreurs(Model model,@AuthenticationPrincipal UserDetails currentUser) {
        List<Livreur> livreurs = livreurService.getAll();
        model.addAttribute("livreurs", livreurs);
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }return "adminLivreurs";
    }

    @GetMapping("/Livreur")
    public String showRegistrationfrom(Model model,@AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        Livreur livreur = new Livreur();
        model.addAttribute("livreur",livreur);
        return  "addLivreur";
    }

    @PostMapping("/register/livreur")
    public String registration(@Valid @ModelAttribute("livreur") Livreur livreur,Model model,
                               @AuthenticationPrincipal UserDetails currentUser){

        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        livreurService.ajoueLivreur(livreur);
        return "redirect:/adminLivreurs?success";

    }

    @GetMapping("/updateLivreur/{id}")
    public  String  showFormForUpdateLivreur(@PathVariable(value = "id") Integer id, Model model,
                                      @AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        Livreur livreur = livreurService.findLivreurByDI(id);
        model.addAttribute("livreur",livreur);
        return "updateLivreur";
    }

    @PostMapping("/update/livreur")
    public String updateLivreurByAdmin(@ModelAttribute("livreur") Livreur livreur){
        livreurService.updateLivreur(livreur);
        return "redirect:/adminLivreurs?update";
    }

    @GetMapping("/deleteLivreur/{id}")
    public  String deletelivreur(@PathVariable(value = "id") Integer id,Model model, @AuthenticationPrincipal UserDetails currentUser ){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
         livreurTodelete = livreurService.findLivreurByDI(id);
        return "deletePageLivreur";
    }

    @GetMapping("/deleteLivreur")
    public  String deletelivreurConfirm( ){
        livreurService.deleteLivreur(livreurTodelete.getId());
        return "redirect:/adminLivreurs?delete";
    }

    @RequestMapping("/deletePageAdmin/{id}")
    public String showDeletePageAdmin(@PathVariable(value = "id") Integer id,Model model, @AuthenticationPrincipal UserDetails currentUser ) {
        UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
        model.addAttribute("connectedUser", userDto);
        userToDelete =userService.findUserById(id);


        return "deletePageAdmin";
    }
    @GetMapping("/deleteAdmin")
    public  String deleteUserByAdmin1(@ModelAttribute("userToDelete") User user,Model model,@AuthenticationPrincipal UserDetails currentUser ){
        UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
        model.addAttribute("connectedUser", userDto);

        userService.deleteUser(userToDelete.getId());
        return "redirect:/adminSpace?delete";
    }

    @GetMapping("/promotion")
    public String promotion(Model model,@AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        UserDto user =new UserDto();
        model.addAttribute("user",user);
        model.addAttribute("count",PanierController.count );
        return "promotion";
    }

    @PostMapping("/mailPromo")
    public String mail(Model model,UserDto userDto1, @AuthenticationPrincipal UserDetails currentUser){

        model.addAttribute("user", userDto1);
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        List<UserDto> topList = userService.findTopUsers();
        for (UserDto dto : topList) {
            emailSenderService.sendSimpleEmailByCom(dto.getEmail() , userDto1.getLastName(),userDto1.getAddress());
        }

        return "redirect:/adminTopClients?success";
    }

}
