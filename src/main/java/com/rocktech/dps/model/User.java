package com.rocktech.dps.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String userName;
    private String fullName;
    private String password;
    private String phoneNumber;
    private String country;
    private String location;
    private String address;
    private String gender;
    private Date registeredDate;



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = { @JoinColumn(name = "USER_ID")},
            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID")}
    )
    private Set<Role> roles;
}
