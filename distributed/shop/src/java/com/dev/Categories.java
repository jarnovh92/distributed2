package com.dev;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joren
 */

public class Categories {
    
    private String name;
    private int id;
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void setId(int id) {
        this.id = id;
    }
    
    int getId(){
        return id;
    }

}