package com.analistas.traductorfx;

import com.analistas.traductorfx.repository.IdiomaRepository;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        var panel = new AnchorPane();
        var escena = new Scene(panel, 540, 200);
        
        var lblTraductor = new Label("Palabra en Español: ");
        var txfPalabra = new TextField();//palabra a traducir
        var txfTraducion = new TextField();//palabra traducida
        var cmbIdiomas = new ComboBox();
        
        var idiomaRepo = new IdiomaRepository();
        
        
        panel.getChildren().addAll(lblTraductor,txfPalabra,
                                    txfTraducion, cmbIdiomas);
        
        stage.setTitle("Traductor de Palabras");
        stage.setScene(escena);
        stage.setResizable(false);
        stage.show();
        
        //Posicion de los componentes:
        
        //label
        lblTraductor.setLayoutX(20);
        lblTraductor.setLayoutY(20);
        
        //Textfields
        txfPalabra.setLayoutX(20);
        txfPalabra.setLayoutY(40);
        
        txfTraducion.setLayoutX(panel.getWidth() - txfTraducion.getWidth() - 20);
        txfTraducion.setLayoutY(40);
        
        //comboBox
        cmbIdiomas.setLayoutX(20 + txfPalabra.getWidth() + 20);
        cmbIdiomas.setLayoutY(40);
        cmbIdiomas.getItems().addAll(idiomaRepo.getIdiomas());
        cmbIdiomas.setPromptText("Seleccionar un idioma");
        
    }

    public static void main(String[] args) {
        launch();
    }

}