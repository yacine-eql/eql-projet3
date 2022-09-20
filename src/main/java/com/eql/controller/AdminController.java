package com.eql.controller;


import com.eql.dto.UserDto;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    ProduitService produitService;
    @Autowired
    CommandeService commandeService;


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


}
