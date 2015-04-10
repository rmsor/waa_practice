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

    private double grandTotalPrice = 0.00;

    String selectedCat = "White Tea";

    String selectedTea = "";

    Tea selTea;

    private ArrayList<Tea> selTeas;

    public TeaSelect() {
        teaExp = new TeaExpert();
    }

    public TeaExpert getTeaExp() {
        return teaExp;
    }

    public ArrayList<Tea> getTeaByCat() {
        ArrayList<Tea> catTeas = new ArrayList();
        for (Tea t : teaExp.getTeaList()) {
            if (t.getCategory().getCatname().equals(selectedCat)) {
                catTeas.add(t);
            }
        }
        return catTeas;
    }

    public String getSelectedTea(String selTeaS) {
        selectedTea = selTeaS;
        for (Tea t : teaExp.getTeaList()) {
            if (t.getName().equals(selectedTea)) {
                selTea = (Tea) t;
            }
        }
        return "getdeatails";
    }
    public String getSelectedCat(String selCat){
        selectedCat=selCat;
        return "dashboard";
    }

    public String save() {
        selTeas=new ArrayList();
        grandTotalPrice = 0.00;
        selTeas.add(selTea);
        for (Tea t : selTeas) {
            grandTotalPrice += t.getPrice() * t.getQuantity();
        }
        return "orderdetail";
    }

    public ArrayList<Tea> getSelTeas() {
        return selTeas;
    }

    public double getGrandTotalPrice() {
        return grandTotalPrice;
    }

    public String getSelectedCat() {
        return selectedCat;
    }

    public String getSelectedTea() {
        return selectedTea;
    }

    public Tea getSelTea() {
        return selTea;
    }

}
