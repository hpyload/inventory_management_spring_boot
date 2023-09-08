package com.back_end.dto;

import com.back_end.entity.Address;
import com.back_end.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private Long id;

    private String name;

    private String description;

    private AddressDto address;

    private String photo;

    private String email;

    private String phone;

    private String website;

    @JsonIgnore
    private List<UserDto> users;

}
