package org.example.entity;


import org.example.utils.ClientsState;

import javax.persistence.*;

@Entity
@Table (name="clients")
public class Clients {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String companyName;

    private String firstName;

    private String lastName;

    private String email;


    private String phone;
    @Column (name="address" , columnDefinition = "text")
    private String address;

    private String zipCode;

    private String city;

    private String country;
    @Column (name="state" , columnDefinition = "bit")
    private ClientsState state;

    public Clients() {

    }

    public Clients(Integer id, String companyName, String firstName, String lastName, String email, String phone, String address, String zipCode, String city, String country, ClientsState state) {
        this.id = id;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.state = state;
    }

    public Clients(String name) {
        this.firstName = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public ClientsState getState() {
        return state;
    }

    public void setState(ClientsState state) {
        this.state = state;
    }

    public void setNotNullData(Clients newClientsData){
        if(newClientsData.getCompanyName() != null) {
            this.setCompanyName(newClientsData.getCompanyName());
        }
        if(newClientsData.getFirstName() != null) {
            this.setFirstName(newClientsData.getFirstName());
        }

        if(newClientsData.getLastName() != null) {
            this.setLastName(newClientsData.getLastName());
        }

        if(newClientsData.getEmail() != null) {
            this.setEmail(newClientsData.getEmail());
        }

        if(newClientsData.getPhone() != null) {
            this.setPhone(newClientsData.getPhone());
        }

        if(newClientsData.getAddress() != null) {
            this.setAddress(newClientsData.getAddress());
        }

        if(newClientsData.getZipCode() != null) {
            this.setZipCode(newClientsData.getZipCode());
        }

        if(newClientsData.getCity() != null) {
            this.setCity(newClientsData.getCity());
        }

        if(newClientsData.getCountry() != null) {
            this.setCountry(newClientsData.getCountry());
        }

        if(newClientsData.getState() != null) {
            this.setState(newClientsData.getState());
        }
    }
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state=" + state +
                '}';
    }
}
