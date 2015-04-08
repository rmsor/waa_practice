/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TeaExpert {

    private HashMap<String, Tea> teaList = new HashMap();

    public TeaExpert() {
        teaList.put("Green Tea", new Tea("Green Tea", "Over the last few decades green tea has been subjected to many scientific and medical studies to determine the extent of its long-purported health benefits, with some evidence suggesting that regular green tea drinkers have lower chances of heart disease and developing certain types of cancer.", "30 mg/cup", "Green tea can reduce the risk of cardiovascular disease, dental cavities, kidney stones, and cancer, while improving bone density and cognitive function. However, the human studies are inconsistent. Green tea consumption is associated with reduced heart disease in epidemiological studies.", "75-80 °C (167-176 °F)", "1–2 minutes", "Aracha, Bancha, Bi Luo Chun, Chun Mee, Da Fang, Genmaicha, Guapian, Gunpowder, Gyokuro, Hojicha, Hou Kui, Huang Shan Mao Feng, Kabusecha, mairicha, Konacha, Kukicha, Longjing, Matcha, Mao Jian, Mecha, Meng Ding Gan Lu, Sencha, Shincha, Tamaryokucha", 100.00));
        teaList.put("Black Tea", new Tea("Black Tea", "", "", "", "", "", "", 110.00));
        teaList.put("Oolong Tea", new Tea("Oolong Tea", "", "", "", "", "", "", 120.00));
        teaList.put("Pu Erh Tea", new Tea("Pu Erh Tea", "", "", "", "", "", "", 130.00));
        teaList.put("White Tea", new Tea("White Tea", "", "", "", "", "", "", 140.00));
        teaList.put("Yellow Tea", new Tea("Yellow Tea", "", "", "", "", "", "", 150.00));
    }

    public Tea findTea(String teaName) {
        return teaList.get(teaName);
    }

    public HashMap<String, Tea> getTeaList() {
        return teaList;
    }

    public List<Tea> getTeaArrayList() {
        List<Tea> teas = new ArrayList<Tea>();
        for (Tea myTea : teaList.values()) {
            teas.add(myTea);
        }
        //teas = (List) teaList.values();
        return teas;
    }

    public Set getKeys() {
        return teaList.keySet();
    }

}
