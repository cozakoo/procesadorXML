/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.SimpleType;

/**
 *
 * @author dgc06
 */
public class StringSimpleTyoe {
    private String value;
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value){
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
