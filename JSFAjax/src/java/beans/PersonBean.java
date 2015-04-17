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
import entities.Person;
import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

@Named("pb")

@RequestScoped

public class PersonBean implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String streetAddress;
    private String zip;
    private String state;
    private String msg;
    private String msgColor;

    private ArrayList<Person> persons = new ArrayList();

    public PersonBean() {
        persons.add(new Person("Ramesh", "Pathak", "rmsor.pth02@gmail.com", "1000N 4TH ST Fairfield IA", "52557", "IA"));
        persons.add(new Person("Dharma", "Poudel", "dharma@gmail.com", "1000N 4TH ST MUM MR #62", "52557", "IA"));
        persons.add(new Person("Raz", "Mahato", "raz@gmail.com", "1000N 4TH ST MUM MR #65", "52557", "IA"));
    }

    public void searchName() {
        boolean found = false;
        for (Person ps : persons) {
            if (ps.getFirstName().equalsIgnoreCase(firstName)) {
                setEmail(ps.getEmail());
                setLastName(ps.getLastName());
                setEmail(ps.getEmail());
                setStreetAddress(ps.getStreetAddress());
                setZip(ps.getZip());
                setState(ps.getState());
                found = true;
                setMsg("User Found !!");
                setMsgColor("green");
                return;
            }
        }
        if (!found) {
            setMsg("User Not Found !!!");
            setMsgColor("red");
        }
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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgColor() {
        return msgColor;
    }

    public void setMsgColor(String msgColor) {
        this.msgColor = msgColor;
    }

}
