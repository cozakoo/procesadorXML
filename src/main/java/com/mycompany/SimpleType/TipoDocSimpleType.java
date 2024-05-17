/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.SimpleType;

/**
 *
 * @author dgc06
 */
public class TipoDocSimpleType {
     protected static final int MAX_DIGITS = 2;
     private short value;
         
     
       public short getValue() {
        return value;
    }
     
     public void setValue(short value){
         if (String.valueOf(value).length() > MAX_DIGITS) {
            throw new IllegalArgumentException("String length exceeds maximum allowed length of " + MAX_DIGITS);
        }
        this.value = value;
    }

}
