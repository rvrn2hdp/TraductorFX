package com.analistas.traductorfx;

import com.analistas.traductorfx.model.Idioma;
import com.analistas.traductorfx.model.Palabra;
import com.analistas.traductorfx.repository.IdiomaRepository;
import com.analistas.traductorfx.repository.PalabraRepository;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
    
    
    static IdiomaRepository idiomaRepo = new IdiomaRepository();
    static PalabraRepository palabraRepo = new PalabraRepository();

    @Override
    public void start(Stage stage) {
        
        var panel = new AnchorPane();
        var escena = new Scene(panel, 540, 200);
        
        var lblTraductor = new Label("Palabra en Español: ");
        var txfPalabra = new TextField();//palabra a traducir
        var txfTraducion = new TextField();//palabra traducida
        var cmbIdiomas = new ComboBox();
        
        
        
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
        
        //manejado de evento del combobox, para realizar las traducciones:
        cmbIdiomas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Palabra palabra = new Palabra();
                palabra.setPalabra(txfPalabra.getText().trim().toLowerCase());
                palabra.setIdioma((Idioma)cmbIdiomas.getItems().get(4));
                txfTraducion.setText("ninguna");
            }
        });
        
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static String traducirPalabra(Palabra palabra, Idioma idioma) {
        String traduccion = "palabra no encontrada";
        
        for(Palabra p : palabraRepo.getPalabrasEsp()) {
            if(p.getPalabra().toLowerCase().equals(palabra.getPalabra().toLowerCase())) {
                palabra.setId(p.getId());
                
                switch (idioma.getId()) {
                    case 1:
                        traduccion = palabraRepo.getPalabrasIng().get(palabra.getId()-1).getPalabra();
                        break;
                    case 2:
                        
                    default:
                        throw new AssertionError();
                }
            }
        }
        
        return traduccion;
        
    }
    
    

}