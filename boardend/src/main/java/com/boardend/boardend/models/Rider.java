package com.boardend.boardend.models;

import javax.persistence.*;

@Entity
@Table(name = "business_riders")
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "email")
    private String email;

    @Column(name = "availability")
    private boolean available;

    public Rider() {

    }

    public Rider(String firstName, String lastName,
                 String phoneNumber, String streetAddress,
                 String email,
                 boolean available) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.email = email;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean isAvailable) {
        this.available = isAvailable();
    }

    @Override
    public String toString() {
        return "business_riders [" +
                "id=" + id + ", " +
                "first_name=" + firstName + ", " +
                "last_name=" + lastName + ", " +
                "phone_number=" + phoneNumber + ", " +
                "street_address=" + streetAddress + ", " +
                "email=" + email + "]";
    }

}