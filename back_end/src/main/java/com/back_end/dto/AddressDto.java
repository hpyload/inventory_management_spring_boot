package com.back_end.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String address;

    private String country;

    private String city;

    private String postalCode;

}
