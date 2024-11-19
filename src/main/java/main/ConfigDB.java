/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author dgc06
 */
public class ConfigDB {

    private static final String CONFIG_FILE = "config.properties";
    private static Properties propiedades;
    private static ConfigDB instance = null;

    public ConfigDB() {
        this.propiedades = new Properties();
        cargarPropiedades();
        
    }

    private void cargarPropiedades() {
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            propiedades.load(fis);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de configuración: " + e.getMessage());
        }
    }

    public static ConfigDB getInstance() {
        if (instance == null) {
            instance = new ConfigDB();
        }
        return instance;
    }

    public int getAnio() {
        String anioStr = propiedades.getProperty("db.year");
        return anioStr != null ? Integer.parseInt(anioStr) : 0;
    }

    // Cambiar y guardar el año en el archivo de configuración
    public void setAnio(int anio) {
        propiedades.setProperty("db.year", String.valueOf(anio));
        guardarPropiedades();
    }
    
    private void guardarPropiedades() {
        try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {
            propiedades.store(fos, "Configuración de la Base de Datos");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de configuración: " + e.getMessage());
        }
    }
    
    
}
