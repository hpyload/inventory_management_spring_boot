package com.back_end.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String firstName;

    private String lastName;

    private String email;

    private Instant birthdate;

    private String username;

    private String password;

    @Embedded
    private Address address;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
