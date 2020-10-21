package com.example.ecommercemubuto.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {


    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> woman = new ArrayList<String>();
        woman.add("Clothing");
        woman.add("Shoe");
        woman.add("Bag");
        woman.add("Accessories");
        woman.add("Cosmetic");

        List<String> male = new ArrayList<String>();
        male.add("Clothing");
        male.add("Shoe");
        male.add("Bag");
        male.add("Accessories");
        male.add("Cosmetic");

        List<String> child = new ArrayList<String>();
        child.add("Clothing");
        child.add("Shoe");
        child.add("Bag");
        child.add("Accessories");

        List<String>cosmetic = new ArrayList<String>();
        cosmetic.add("Make-up");
        cosmetic.add("Perfume&Deodorant");
        cosmetic.add("Skin care");
        cosmetic.add("Hair care");

        List<String>homelife = new ArrayList<String>();
        homelife.add("Tableware & Kitchen");
        homelife.add("Bathroom");
        homelife.add("Home textiles");




        expandableListDetail.put("WOMAN",woman);
        expandableListDetail.put("MALE", male);
        expandableListDetail.put("CHILD",child);
        expandableListDetail.put("COSMETIC",cosmetic);
        expandableListDetail.put("HOME & LIFE",homelife);
        return expandableListDetail;
    }
}
