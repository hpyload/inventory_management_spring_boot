package com.back_end.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String street;

    private String city;

    private String state;

    private String postalCode;

}
