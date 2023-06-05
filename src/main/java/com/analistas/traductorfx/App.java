package com.analistas.traductorfx;

import com.analistas.traductorfx.model.Idioma;
import com.analistas.traductorfx.model.Palabra;
import com.analistas.traductorfx.repository.IdiomaRepository;
import com.analistas.traductorfx.repository.PalabraRepository;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
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

        var lblTraductor = new Label("Palabra a Traducir: ");
        var lblTraduccion = new Label("Palabra Traducida: ");
        var txfPalabra = new TextField();//palabra a traducir
        var txfTraducion = new TextField();//palabra traducida
        var cmbIdiomaInicial = new ComboBox();
        var cmbIdiomaATraducir = new ComboBox();

        panel.getChildren().addAll(lblTraductor, txfPalabra,
                txfTraducion, cmbIdiomaATraducir, cmbIdiomaInicial,
                lblTraduccion);

        stage.setTitle("Traductor de Palabras");
        stage.setScene(escena);
        stage.setResizable(false);
        stage.show();

        //Posicion de los componentes:
        //label
        lblTraductor.setLayoutX(20);
        lblTraductor.setLayoutY(20);
        lblTraduccion.setLayoutX(panel.getWidth() - txfTraducion.getWidth() - 40);
        lblTraduccion.setLayoutY(20);

        //Textfields
        txfPalabra.setLayoutX(20);
        txfPalabra.setLayoutY(40);

        txfTraducion.setLayoutX(panel.getWidth() - txfTraducion.getWidth() - 40);
        txfTraducion.setLayoutY(40);

        //comboBox
        cmbIdiomaInicial.setLayoutX(20);
        cmbIdiomaInicial.setLayoutY(70);
        //cmbIdiomaUno.setMaxSize(150, 30);
        cmbIdiomaInicial.getItems().addAll(idiomaRepo.getIdiomas());
        cmbIdiomaInicial.setPromptText("Seleccionar un idioma");

        cmbIdiomaATraducir.setLayoutX(panel.getWidth() - txfTraducion.getWidth() - 40);
        cmbIdiomaATraducir.setLayoutY(70);
        cmbIdiomaATraducir.getItems().addAll(idiomaRepo.getIdiomas());
        cmbIdiomaATraducir.setPromptText("Seleccionar un idioma");

        //manejador de evento del combobox, para realizar las traducciones:
        cmbIdiomaATraducir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Palabra palabra = new Palabra();
                palabra.setPalabra(txfPalabra.getText().trim().toLowerCase());
                
                Idioma idiomaInicial = (Idioma) cmbIdiomaInicial.getSelectionModel().getSelectedItem();
                palabra.setIdioma(idiomaInicial);

                Idioma idiomaAtraducir = (Idioma) cmbIdiomaATraducir.getSelectionModel().getSelectedItem();
                txfTraducion.setText(traducir(palabra, idiomaAtraducir));
            }
        });

    }

    public static void main(String[] args) {
        launch();
    }

    public static String traducirPalabra(Palabra palabra, Idioma idiomaATraducir) {

        String traduccion = "palabra no encontrada";
        
        for (Palabra p : palabraRepo.getPalabrasPor()) {
            if (p.getPalabra().toLowerCase().equals(palabra.getPalabra().toLowerCase())) {

                palabra.setId(p.getId());

                switch (idiomaATraducir.getId()) {
                    case 1:
                        traduccion = palabraRepo.getPalabrasEsp().get(palabra.getId() - 1).getPalabra();
                        break;
                    case 2:
                        traduccion = palabraRepo.getPalabrasIng().get(palabra.getId() - 1).getPalabra();
                        break;
                    case 3:
                        traduccion = palabraRepo.getPalabrasPor().get(palabra.getId() - 1).getPalabra();
                        break;
                    default:
                        break;
                }
            }
        }

        for (Palabra p : palabraRepo.getPalabrasIng()) {
            if (p.getPalabra().toLowerCase().equals(palabra.getPalabra().toLowerCase())) {

                palabra.setId(p.getId());

                switch (idiomaATraducir.getId()) {
                    case 1:
                        traduccion = palabraRepo.getPalabrasEsp().get(palabra.getId() - 1).getPalabra();
                        break;
                    case 2:
                        traduccion = palabraRepo.getPalabrasIng().get(palabra.getId() - 1).getPalabra();
                        break;
                    case 3:
                        traduccion = palabraRepo.getPalabrasPor().get(palabra.getId() - 1).getPalabra();
                        break;
                    default:
                        break;
                }
            }
        }
        
        for (Palabra p : palabraRepo.getPalabrasEsp()) {
            if (p.getPalabra().toLowerCase().equals(palabra.getPalabra().toLowerCase())) {

                palabra.setId(p.getId());

                switch (idiomaATraducir.getId()) {
                    case 1:
                        traduccion = palabraRepo.getPalabrasEsp().get(palabra.getId() - 1).getPalabra();
                        break;
                    case 2:
                        traduccion = palabraRepo.getPalabrasIng().get(palabra.getId() - 1).getPalabra();
                        break;
                    case 3:
                        traduccion = palabraRepo.getPalabrasPor().get(palabra.getId() - 1).getPalabra();
                        break;
                    default:
                        break;
                }
            }
        }

        return traduccion;

    }

    public static String traducir(Palabra palabra, Idioma idioma) {
        
        String traduccion = "Palabra no encontrada.";
        List <Palabra> listaIdioma = palabraRepo.getPalabrasEsp();
        
        switch (palabra.getIdioma().getId()) {
            case 1:
                listaIdioma = palabraRepo.getPalabrasEsp();
                break;
            case 2:
                listaIdioma = palabraRepo.getPalabrasIng();
                break;
            case 3:
                listaIdioma = palabraRepo.getPalabrasPor();
                break;
            default:
                break;
        }
        
        for (Palabra p : listaIdioma) {
            if (p.getPalabra().toLowerCase().equals(palabra.getPalabra().toLowerCase())) {

                palabra.setId(p.getId());

                switch (idioma.getId()) {
                    case 1:
                        traduccion = palabraRepo.getPalabrasEsp().get(palabra.getId() - 1).getPalabra();
                        break;
                    case 2:
                        traduccion = palabraRepo.getPalabrasIng().get(palabra.getId() - 1).getPalabra();
                        break;
                    case 3:
                        traduccion = palabraRepo.getPalabrasPor().get(palabra.getId() - 1).getPalabra();
                        break;
                    default:
                        break;
                }
            }
        }
        
        return traduccion;
    }
}
