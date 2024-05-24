/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simple_type;

/**
 *
 * @author dgc06
 */
public class CuitSimpleType {
     protected static final int MAX_DIGITS = 11;
     private long value;
         
     
     
     public void setValue(long value){
         if (String.valueOf(value).length() > MAX_DIGITS) {
            throw new IllegalArgumentException("String length exceeds maximum allowed length of " + MAX_DIGITS);
        }
        this.value = value;
    }
     
       public long getValue() {
        return value;
    }
     
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
  
}