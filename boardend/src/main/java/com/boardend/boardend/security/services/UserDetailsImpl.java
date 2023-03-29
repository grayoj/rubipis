package com.boardend.boardend.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.boardend.boardend.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String companyName;

    private String email;

    private String username;

    private String cacNumber;

    @JsonIgnore
    private String password;

    private String streetAddress;

    private String companyState;

    private String riderNumber;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String companyName, String email, String cacNumber, String username, String password,
                           String streetAddress, String companyState, String riderNumber,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.companyName = companyName;
        this.email = email;
        this.cacNumber = cacNumber;
        this.username = username;
        this.password = password;
        this.streetAddress = streetAddress;
        this.companyState = companyState;
        this.riderNumber = riderNumber;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getCompanyName(),
                user.getUsername(),
                user.getEmail(),
                user.getCacNumber(),
                user.getPassword(),
                user.getStreetAddress(),
                user.getCompanyState(),
                user.getRiderNumber(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCacNumber() {
        return cacNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCompanyState() {
        return companyState;
    }

    public String getRiderNumber() {
        return riderNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}