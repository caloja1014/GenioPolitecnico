/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geniopolitecnico;
import interfaces.Inicio;
import interfaces.Preguntas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CLOJA
 */
public class GenioPolitecnico extends Application{
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage){
		
		Scene escenaInicio = new Scene( new Preguntas().getRoot(),300,400);
		
		primaryStage.setScene(escenaInicio);
		
		
		
		primaryStage.show();
		
	}
    
}
