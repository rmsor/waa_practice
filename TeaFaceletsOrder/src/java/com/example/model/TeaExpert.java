/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.util.ArrayList;

public class TeaExpert {

    private ArrayList<Tea> teaList = new ArrayList();
    private ArrayList<Category> catList = new ArrayList();

    public TeaExpert() {
        Category whiteTea=new Category("White Tea", "silverneedlewhitetea.jpg");
        Category greenTea=new Category("Green Tea", "FloweringPineappleBloomingWhiteTea.jpg");
        Category blackTea=new Category("Black Tea", "FloweringPineappleBloomingWhiteTea.jpg");
        catList.add(whiteTea);
        catList.add(greenTea);
        catList.add(blackTea);
        teaList.add(new Tea("Silve Needle White Tea", "Rarity and fame cloak our legendary Silver Needle white tea downy buds, which hold the highest of honors as one of the top teas in China. Reserved for the Chinese Imperial family for centuries, this tea is reverently hand-harvested only two days of the entire year. The leaves are uniquely beautiful and silver tipped exuding royalty and an exceptional soft, smooth, sweet-silky luxuriousness. ", 15.00,whiteTea,"silverneedlewhitetea.jpg"));
        teaList.add(new Tea("Flowering Pineapple Blooming White Tea", "A truly artisanal white tea that unfurls into an ethereal display of exquisite flavor and beauty. Each hand-tied tea ball blooms with a crown of marigold flowers gently scented with luscious pineapple and can be infused three to five times. ", 10.00,whiteTea,"FloweringPineappleBloomingWhiteTea.jpg"));
        teaList.add(new Tea("Youthberry White Tea", "Delicate white tea gets its youthful blush from red currants, açai berry, hibiscus and rose petals. Candied pineapple and mango pieces mingle with Fuji and golden delicious apples in this sweetly timeless elixir. ", 20.00,whiteTea,"youthberrywhitetea.jpg"));
        teaList.add(new Tea("Pu Erh Tea", "", 130.00,greenTea,""));
        teaList.add(new Tea("White Tea", "", 140.00,greenTea,""));
        teaList.add(new Tea("Yellow Tea", "", 150.00,greenTea,""));
        teaList.add(new Tea("Yellow Tea", "", 150.00,blackTea,""));
        teaList.add(new Tea("Yellow Tea", "", 150.00,blackTea,""));
        teaList.add(new Tea("Yellow Tea", "", 150.00,blackTea,""));
    }

    public ArrayList<Tea> getTeaList() {
        return teaList;
    }

    public ArrayList<Category> getCatList() {
        return catList;
    }
    
    
    

}
