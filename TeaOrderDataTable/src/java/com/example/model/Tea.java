/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

/**
 *
 * @author rmsor_000
 */
public class Tea {
    String name;
    String description;
    String caffine;
    String healthBenifits;
    String waterTemperature;
    String sleepTime;
    String varities;
    int quantity;
    double price;

    public Tea(String name, String description, String caffine, String healthBenifits, String waterTemperature, String sleepTime, String varities,double price) {
        this.name = name;
        this.description = description;
        this.caffine = caffine;
        this.healthBenifits = healthBenifits;
        this.waterTemperature = waterTemperature;
        this.sleepTime = sleepTime;
        this.varities = varities;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getDescription() {
        return description;
    }

    public String getCaffine() {
        return caffine;
    }

    public String getHealthBenifits() {
        return healthBenifits;
    }

    public String getWaterTemperature() {
        return waterTemperature;
    }

    public String getSleepTime() {
        return sleepTime;
    }

    public String getVarities() {
        return varities;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
}
