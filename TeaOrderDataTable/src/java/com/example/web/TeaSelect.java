/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import com.example.model.Tea;
import com.example.model.TeaExpert;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author rmsor_000
 */
@Named("tea")
@SessionScoped
public class TeaSelect implements Serializable {

    private TeaExpert teaExp;
    
    private double grandTotalPrice=0.00;
    
    private ArrayList<Tea> selTeas;

    public TeaSelect() {
        teaExp = new TeaExpert();
    }

    public TeaExpert getTeaExp() {
        return teaExp;
    }

    public String save() {
        selTeas = new ArrayList();
        grandTotalPrice=0.00;
        for (Tea t : teaExp.getTeaList()) {
            if(t.isEditable()){
                selTeas.add(t);
                grandTotalPrice+=t.getPrice()*t.getQuantity();
            }
            t.setEditable(false);
        }
        return "orderdetail";
    }

    public ArrayList<Tea> getSelTeas() {
        return selTeas;
    }

    public double getGrandTotalPrice() {
        return grandTotalPrice;
    }
    
    
    

}
