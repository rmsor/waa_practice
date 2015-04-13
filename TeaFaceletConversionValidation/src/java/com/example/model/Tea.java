/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.io.Serializable;

/**
 *
 * @author rmsor_000
 */
public class Tea implements Serializable {

    String name;
    String description;
    int quantity;
    double price;
    private boolean editable;
    Category category;
    String picture;

    public Tea(String name, String description, double price, Category category, String picture) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.picture = picture;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean newValue) {
        editable = newValue;
    }

    public Category getCategory() {
        return category;
    }

    public String getPicture() {
        return picture;
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

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

}
