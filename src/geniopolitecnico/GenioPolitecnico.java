/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniopolitecnico;

import arbol.BT;
import interfaces.Acierto;
import interfaces.Desacierto;
import interfaces.Inicio;
import interfaces.Preguntas;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author CLOJA
 */
public class GenioPolitecnico extends Application {

    public static final BT<String> arbol = BT.cargarArbol();
    public static final Stage stage = new Stage();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Inicio inicio = new Inicio();
        Preguntas preguntas = new Preguntas();
        Scene escena = new Scene(inicio.getRoot(), 300, 400);
        escena.getStylesheets().add(getClass().getResource("/data/estilos.css").toExternalForm());
        inicio.getJugar().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                escena.setRoot(preguntas.getRoot());
                
            }

        });
        stage.setScene(escena);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();

    }

}
