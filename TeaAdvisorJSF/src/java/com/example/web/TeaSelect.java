/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import com.example.model.Tea;
import com.example.model.TeaExpert;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author rmsor_000
 */
@Named("tea")
@RequestScoped
public class TeaSelect {

    String selecteTea;
    
    TeaExpert teaExp;
    
    Tea objTea;
    
    Set listOfTeas;
    
    public TeaSelect() {
       teaExp=new TeaExpert();
       listOfTeas=teaExp.getKeys();
    }
    public String getTeaInfo(){
        objTea= teaExp.findTea(selecteTea);
        return "teadetail";
    }

    public String getSelecteTea() {
        return selecteTea;
    }

    public Set getListOfTeas() {
        return listOfTeas;
    }

    public void setSelecteTea(String selecteTea) {
        this.selecteTea = selecteTea;
    }

    public Tea getObjTea() {
        return objTea;
    }
    
    
    
}
