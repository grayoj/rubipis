package com.boardend.boardend.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String companyName;
    private String email;
    private String cacNumber;

    private String username;

    private String streetAddress;

    private String companyState;

    private String riderNumber;

    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String companyName, String email, String cacNumber, String username,
                       String streetAddress, String companyState, String riderNumber, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.companyName = companyName;
        this.email = email;
        this.cacNumber = cacNumber;
        this.username = username;
        this.streetAddress = streetAddress;
        this.companyState = companyState;
        this.riderNumber = riderNumber;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        this.riderNumber = riderNumber;
    }

    public List<String> getRoles() {
        return roles;
    }
}