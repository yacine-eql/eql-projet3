package com.eql.service.impl;

import com.eql.dto.UserDto;
import com.eql.model.Role;
import com.eql.repository.RoleRepository;
import com.eql.repository.UserRepository;
import com.eql.model.User;
import com.eql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void createUser(User user) {

    }

    @Override
    public void logOut() {

            System.out.println("Login Out");

        }

    @Override
    public void modifieUser(long idUser,String nom,String prenom,String email,String password, String adresse) {
        User user = userRepository.findById(idUser).get();
        user.setName(nom);

        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(adresse);

        userRepository.save(user);
    }



    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAddress(userDto.getAddress());
        user.setTel((userDto.getTel()));
        Role role = roleRepository.findByName("ROLE_USER");

        if (role==null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public void saveUserUpdate(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).get();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAddress(userDto.getAddress());
        user.setTel((userDto.getTel()));
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();

        user.setIsActive(false);
        user.setPassword(passwordEncoder.encode("delete"));
        userRepository.save(user);
    }

    private Role checkRoleExist() {
        Role role =new Role();
        role.setName("ROLE_USER");
        return  roleRepository.save(role);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<UserDto> findAllUser() {
        List<User> users = userRepository.findAll();

        users.remove(userRepository.findByEmail("admin@gmail.com"));
        for (Iterator<User> it = users.iterator(); it.hasNext();) {
            User s = it.next();

            if (!s.getIsActive()){
                it.remove();
            }
        }

        return users.stream()
                .map( user -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllNewUsers() {
        List<User> users = userRepository.findAll();

        for (Iterator<User> it = users.iterator(); it.hasNext();) {
            User s = it.next();

            if (!s.getCommandes().isEmpty()||!s.getIsActive()){
                it.remove();
            }
        }

        return users.stream()
                .map( user -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findTopUsers() {
        List<User> users = userRepository.findAll();

        for (Iterator<User> it = users.iterator(); it.hasNext();) {
            User s = it.next();

            if ((s.getCommandes().size() < 5) || !s.getIsActive()){
                it.remove();
            }
        }

        return users.stream()
                .map( user -> mapToUserDto(user))
                .collect(Collectors.toList());
    }


    public UserDto mapToUserDto (User user) {
        UserDto userDto= new UserDto() ;
        String [] str = user.getName().split(" ");
        userDto.setId(user.getId());
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setTel(user.getTel());

        return userDto;
    }


}
