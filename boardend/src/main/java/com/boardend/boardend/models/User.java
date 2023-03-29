package com.boardend.boardend.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "business_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "companyName"),
                @UniqueConstraint(columnNames = "email")
        })

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String companyName;

    @NotBlank
    @Size(max = 50)
    private String cacNumber;

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    @Size(max = 200)
    private String streetAddress;

    @NotBlank
    @Size(max = 50)
    private String companyState;

    @Size(max = 200)
    private String riderNumber;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "business_user_roles",
            joinColumns = @JoinColumn(name = "business_user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String companyName, String cacNumber, String username, String email, String password,
                String streetAddress, String companyState, String riderNumber) {
        this.companyName = companyName;
        this.cacNumber = cacNumber;
        this.username = username;
        this.email = email;
        this.password = password;
        this.streetAddress = streetAddress;
        this.companyState = companyState;
        this.riderNumber = riderNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCacNumber() {
        return cacNumber;
    }

    public void setCacNumber(String cacNumber) {
        this.cacNumber = cacNumber;
    }

    public String getUsername() {return  username;}

    public void setUsername(String username) {this.username = username;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCompanyState() {
        return companyState;
    }

    public void setCompanyState(String companyState) {
        this.companyState = companyState;
    }

    public String getRiderNumber() {
        return riderNumber;
    }

    public void setRiderNumber(String riderNumber) {
        this.companyState = riderNumber;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
