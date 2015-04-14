/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Person;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author 984317
 */
@Named("user")
@SessionScoped
public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String result;
    
    private ArrayList<Person> persons;
    
    public User() {
        persons=new ArrayList();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    public String saveUser(){
        persons.add(new Person(firstName,lastName));
        return "version1";
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }
    public String searchLastName(){
        Iterator it=persons.iterator();
        while(it.hasNext()){
            Person ps=(Person) it.next();
            if(ps.getFirstName().equals(firstName)){
                return ps.getLastName();
            }
        }
        return null;
    }
    
    public void findLastName(){
        result=searchLastName();
    }

    public String getResult() {
        return result;
    }
    
    
    
    
    
}
