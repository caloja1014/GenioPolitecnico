package interfaces;

import geniopolitecnico.GenioPolitecnico;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Acierto {

	private VBox root = new VBox();
	
	private StackPane stackPaneFondo = new StackPane();
	private ImageView fondo = new ImageView(new Image("/imagenes/fondoPregunta.jpg"));
	
	
	private ImageView imagenGenio = new ImageView(new Image("/imagenes/genioAcierto.gif"));
	
	private Label labelAdivinar = new Label("�He Adivinado!");
	
	private FlowPane flowJugarDeNuevo = new FlowPane();
	
	private Label labelJugarDeNuevo = new Label("�Quieres jugar de nuevo?");
	
	private Label si = new Label("S�");
	
	private Label no = new Label("No");
	
	
	public Acierto() {
		organizarElementos();
		ajustarTamanoImagenes();
		ajustarTamanoLabels();
		centralizarTextoEnLabels();
		decorarLabels();
                si.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Preguntas preguntas=new Preguntas();
                        Scene escena= new Scene( preguntas.getRoot(),300,400);
                        GenioPolitecnico.stage.setScene(escena);
                    }
                });
                no.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        GenioPolitecnico.stage.close();
                    }
                });
	}
	
	private void organizarElementos() {
		root.getChildren().addAll(stackPaneFondo,flowJugarDeNuevo);
		stackPaneFondo.getChildren().addAll(fondo,imagenGenio);
		flowJugarDeNuevo.getChildren().addAll(labelAdivinar,labelJugarDeNuevo,si,no);
	}
	private void ajustarTamanoImagenes() {
		fondo.setFitHeight(280);
		fondo.setFitWidth(300);
		imagenGenio.setFitHeight(175);
		imagenGenio.setFitWidth(175);
		
	}
	private void ajustarTamanoLabels() {
		labelAdivinar.setMinWidth(300);
		labelAdivinar.setMinHeight(40);
		
		labelJugarDeNuevo.setMinWidth(300);
		labelJugarDeNuevo.setMinHeight(40);
		
		si.setMinHeight(40);
		si.setMinWidth(150);
		
		no.setMinHeight(40);
		no.setMinWidth(150);
	}
	
	private void centralizarTextoEnLabels() {
		labelAdivinar.setAlignment(Pos.CENTER);
		labelJugarDeNuevo.setAlignment(Pos.CENTER);
		si.setAlignment(Pos.CENTER);
		no.setAlignment(Pos.CENTER);
		
	}
	
	private void decorarLabels() {
		labelAdivinar.setStyle("-fx-background-color:darkred; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 14px;-fx-font-weight:bold");
		labelJugarDeNuevo.setStyle("-fx-background-color:saddlebrown; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 14px;-fx-font-weight:bold");
		si.setStyle("-fx-background-color:darkgoldenrod; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 14px;-fx-font-weight:bold");
		no.setStyle("-fx-background-color:darkgoldenrod; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 14px;-fx-font-weight:bold");
	}
	
        
	//GETTERS & SETTERS

	public VBox getRoot() {
		return root;
	}

	public void setRoot(VBox root) {
		this.root = root;
	}

	public ImageView getFondo() {
		return fondo;
	}

	public void setFondo(ImageView fondo) {
		this.fondo = fondo;
	}

	public ImageView getImagenGenio() {
		return imagenGenio;
	}

	public void setImagenGenio(ImageView imagenGenio) {
		this.imagenGenio = imagenGenio;
	}

	public Label getLabelAdivinar() {
		return labelAdivinar;
	}

	public void setLabelAdivinar(Label labelAdivinar) {
		this.labelAdivinar = labelAdivinar;
	}

	public FlowPane getFlowJugarDeNuevo() {
		return flowJugarDeNuevo;
	}

	public void setFlowJugarDeNuevo(FlowPane flowJugarDeNuevo) {
		this.flowJugarDeNuevo = flowJugarDeNuevo;
	}

	public Label getLabelJugarDeNuevo() {
		return labelJugarDeNuevo;
	}

	public void setLabelJugarDeNuevo(Label labelJugarDeNuevo) {
		this.labelJugarDeNuevo = labelJugarDeNuevo;
	}

	public Label getSi() {
		return si;
	}

	public void setSi(Label si) {
		this.si = si;
	}

	public Label getNo() {
		return no;
	}

	public void setNo(Label no) {
		this.no = no;
	}
	
	
	
	
}
