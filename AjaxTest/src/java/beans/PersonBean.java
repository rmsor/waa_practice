/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author 984317
 */
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

@Named("pb")

@RequestScoped

public class PersonBean implements Serializable {

    private String firstName = "bob";

    private String lastName = "white";

    public PersonBean() {

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

    public String getFullName() {

        return String.format("%s %s", firstName, lastName);

    }

}
