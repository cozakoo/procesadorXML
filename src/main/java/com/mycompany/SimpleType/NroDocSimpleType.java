/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.SimpleType;

/**
 *
 * @author dgc06
 */
public class NroDocSimpleType extends StringSimpleTyoe {
     protected static final int MAX_LENGTH = 11;
     
     public void setValue(String value){
         if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("String length exceeds maximum allowed length of " + MAX_LENGTH);
        }
        super.setValue(value);
    }
}
