/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package procesadorxml_;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author dgc06
 */
public class ProcesadorXML_ extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse(new File("concesionario.xml"));

            loopNodeXml(documento.getDocumentElement());
//            launch(args);

        } catch (ParserConfigurationException ex) {
            System.err.println("excep1");
        } catch (SAXException ex) {
            System.err.println("excep2");

        } catch (IOException ex) {
            System.err.println("excep3");

        }

    }

    public static void loopNodeXml(Node n) {

        // Obtenemos los hijos del nodo
        NodeList hijos = n.getChildNodes();
        
        for (int i = 0; i < hijos.getLength(); i++) {
            // Obtenemos el hijo i
            Node hijo = hijos.item(i);

            // Si es un nodo
            if (hijo.getNodeType() == Node.ELEMENT_NODE) {

                // Recorremos el hijo recursivamente
                loopNodeXml(hijo);

                // Atributos 
                if (hijo.getAttributes() != null && hijo.getAttributes().getLength() > 0) {
                    NamedNodeMap atributos = hijo.getAttributes();
                    for (int j = 0; j < atributos.getLength(); j++) {
                        Node attr = atributos.item(j);
                        // Recorremos el atributo recursivamente
                        loopNodeXml(attr);
                    }
                }

                // si el nodo es un texto y no esta vacio
            } else if (hijo.getNodeType() == Node.TEXT_NODE && !hijo.getTextContent().trim().isEmpty()) {
                // Mostramos el contenido
                System.out.println("Contenido ----> " + hijo.getTextContent());
            }

        }

    }

}
