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
import javax.faces.event.ValueChangeEvent;
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
    private String resultV2;
    
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
    public String searchLastName(String fName){
        String serchNam=fName!=null?fName:firstName;
        Iterator it=persons.iterator();
        while(it.hasNext()){
            Person ps=(Person) it.next();
            if(ps.getFirstName().equals(serchNam)){
                return ps.getLastName();
            }
        }
        return null;
    }
    
    public void findLastName(ValueChangeEvent e){
        String newFirstName = e.getNewValue().toString();
        result=searchLastName(newFirstName);
    }
    public String findLastNameV2(){
        resultV2=searchLastName(null);
        return "version3";
    }

    public String getResult() {
        return result;
    }

    public String getResultV2() {
        return resultV2;
    }
    
    
    
    
    
}
