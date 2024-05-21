package main;

import javax.xml.bind.JAXBException;
import xml.XMLSeccionA;

public class Main {

    public static void main(String[] args) {
        String nombreArchivo = "12345678901_2024_presentacion_001.xml";

        if (XMLSeccionA.esNombreValido(nombreArchivo)) {
            try {
                XMLSeccionA seccionA = new XMLSeccionA(nombreArchivo);
                System.out.println(seccionA.toString());
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El nombre del archivo no es válido.");
        }
    }
}
