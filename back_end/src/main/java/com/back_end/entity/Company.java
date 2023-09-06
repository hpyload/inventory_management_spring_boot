package com.back_end.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company extends BaseEntity{

    private String name;

    private String description;

    @Embedded
    private Address address;

    private String photo;

    private String email;

    private String phone;

    private String website;

    @OneToMany(mappedBy = "company")
    private List<User> users;

}
