package com.eql.service;

import com.eql.dto.UserDto;
import com.eql.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    void logOut();

    void modifieUser(long idUser,String nom,String prenom,String email,String password, String adresse);

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    User findUserById(long id);

    List<UserDto> findAllUser();

    List<UserDto> findAllNewUsers();

    List<UserDto> findTopUsers();




     UserDto mapToUserDto (User user);

     void saveUserUpdate(UserDto userDto);

     void deleteUser(Long id);
}
