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
public class Category {
    String catname;
    String picture;

    public Category(String catname, String picture) {
        this.catname = catname;
        this.picture = picture;
    }

    public String getCatname() {
        return catname;
    }

    public String getPicture() {
        return picture;
    }
    
}
