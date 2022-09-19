package com.eql.controller;

import com.eql.config.SpringSecurity;
import com.eql.dto.UserDto;
import com.eql.model.Commande;
import com.eql.model.Produit;
import com.eql.model.User;
import com.eql.service.CommandeService;
import com.eql.service.ProduitService;
import com.eql.service.UserService;
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
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    ProduitService produitService;
    @Autowired
    CommandeService commandeService;


    @GetMapping("/index")
    public String home(Model model,@AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        return "index";
    }



    @GetMapping("/register")
    public String showRegistrationfrom(Model model){

        UserDto user =new UserDto();
        model.addAttribute("user",user);
        return  "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser!= null && existingUser.getEmail() !=null){
            result.rejectValue("email",null,"Cet email existe deja !");

        }
        if(result.hasErrors()){
            model.addAttribute("user",userDto);
            return "/register";
        }
        userService.saveUser(userDto);
        return "redirect:/login?success";

    }


    @GetMapping("/adminSpace")
    public String users(Model model,Model model1,@AuthenticationPrincipal UserDetails currentUser) {
        List<UserDto> users = userService.findAllUser();
        model.addAttribute("users", users);
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model1.addAttribute("connectedUser", userDto);

        }return "adminSpace";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }



    @RequestMapping("/space")
    public String dashboardPageList(Model model, @AuthenticationPrincipal UserDetails currentUser ) {
        UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
        User user = userService.findUserByEmail(currentUser.getUsername());
        List<Commande> commandes = commandeService.getcommandeByUser(user);
        model.addAttribute("connectedUser", userDto);
        model.addAttribute("commandes",commandes);
        System.out.println(userDto.getFirstName() + userDto.getLastName());
        return "space";
    }

    @GetMapping("/menu")
    public String menu(Model model,@AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        return "menu";
    }

    @GetMapping("/contact")
    public String contact(Model model,@AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        UserDto user =new UserDto();
        model.addAttribute("user",user);
        return "contact";
    }

    @GetMapping("/engagement")
    public String engagement(Model model,@AuthenticationPrincipal UserDetails currentUser){
        if (currentUser != null){
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model.addAttribute("connectedUser", userDto);
        }
        return "engagement";
    }

    @GetMapping("/adminProd")
    public String produits(Model model,Model model1,@AuthenticationPrincipal UserDetails currentUser) {
        List<Produit> produits = produitService.getAllProduct();
        model.addAttribute("produits", produits);
        if (currentUser != null) {
            UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
            model1.addAttribute("connectedUser", userDto);

        }return "adminProd";
    }

    @RequestMapping("/updateAccount")
    public String showUpdatefrom(Model model, @AuthenticationPrincipal UserDetails currentUser ) {
        UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
        model.addAttribute("connectedUser", userDto);
        System.out.println( userDto.getAddress() );
        return "updateAccount";
    }



    @PostMapping("/update/save")
    public String updateUser(@ModelAttribute("connectedUser") UserDto userDto){

        userService.saveUserUpdate(userDto);

        return "redirect:/space?update";

    }

    @RequestMapping("/deletePage")
    public String showDeletePage(Model model, @AuthenticationPrincipal UserDetails currentUser ) {
        UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
        model.addAttribute("connectedUser", userDto);
        return "deletePage";
    }

    @GetMapping("/delete")
    public  String deleteUser(@AuthenticationPrincipal UserDetails currentUser, HttpServletRequest request, HttpServletResponse response ){
        UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
            new SecurityContextLogoutHandler().logout(request, response, authentication);


        userService.deleteUser(userDto.getId());

        return "redirect:/login?delete";
    }
}
