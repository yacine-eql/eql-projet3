package com.eql.dto;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
    @Size( min = 10, max = 13 )
    private String tel;
    @NotEmpty(message = "password should not be empty")
    @Size(min = 6, max = 15)
    private String password;

}
