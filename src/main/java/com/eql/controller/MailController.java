package com.eql.controller;

import com.eql.dto.UserDto;
import com.eql.service.UserService;
import com.eql.webServices.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MailController {


        @Autowired
        EmailSenderService  emailSenderService;

        @Autowired
        UserService userService;


        @PostMapping("/mail")
        public String mail(Model model,UserDto userDto1, @AuthenticationPrincipal UserDetails currentUser){
            model.addAttribute("user", userDto1);
            if (currentUser != null){
                UserDto userDto = userService.mapToUserDto(userService.findUserByEmail(currentUser.getUsername()));
                model.addAttribute("connectedUser", userDto);
            }
            emailSenderService.sendSimpleEmail(userDto1.getEmail() + " Sujet : " + userDto1.getLastName(),userDto1.getAddress());
            return "redirect:/contact?success";
        }
    }


