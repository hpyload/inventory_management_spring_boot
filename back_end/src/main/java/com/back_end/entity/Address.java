package com.back_end.entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address implements Serializable {

    private String address;

    private String country;

    private String city;

    private String postalCode;

}
