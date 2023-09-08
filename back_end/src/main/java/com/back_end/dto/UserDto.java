package com.back_end.dto;

import com.back_end.entity.Address;
import com.back_end.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Instant birthdate;

    private String username;

    private String password;

    private AddressDto address;

    private String photo;

    private CompanyDto company;

}
