package com.eql.dto;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "address should not be empty")
    private String address;
    @NotEmpty(message = "tel should not be empty")
    private String tel;
    @NotEmpty(message = "password should not be empty")
    private String password;

}
