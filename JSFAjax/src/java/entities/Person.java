/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author 984317
 */
public class Person {
    String firstName;
    String lastName;
    String email;
    String streetAddress;
    String zip;
    String state;

    public Person(String firstName, String lastName, String email, String streetAddress, String zip, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.streetAddress = streetAddress;
        this.zip = zip;
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getState() {
        return state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getZip() {
        return zip;
    }
    
}
