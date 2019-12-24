package interfaces;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Preguntas {
	
	private VBox root = new VBox();
	
	private StackPane stackDeFondo = new StackPane();
	
	private ImageView fondo = new ImageView(new Image("/imagenes/fondoPregunta.jpg"));
	
	private ImageView imagenGenio = new ImageView(new Image("/imagenes/genio.png"));
	
	private FlowPane flowDePreguntas = new FlowPane();
	
	private Label pregunta = new Label("¿Es un mamífero?");
	
	private Label si = new Label("Sí");
	
	private Label no = new Label("No");
	
	public Preguntas() {
		organizarElementos();
		ajustarTamanoImagenes();
		ajustarTamanoLabels();
		centralizarTextoEnLabels();
		decorarLabels();
		establecerFuenteLabels();
	}
	
	private void organizarElementos() {
		root.getChildren().addAll(stackDeFondo,flowDePreguntas);
		stackDeFondo.getChildren().addAll(fondo,imagenGenio);
		flowDePreguntas.getChildren().addAll(pregunta,si,no);
	}
	
	private void ajustarTamanoImagenes() {
		imagenGenio.setFitHeight(150);
		imagenGenio.setFitWidth(150);
		fondo.setFitHeight(280);
		fondo.setFitWidth(300);
	}
	
	private void ajustarTamanoLabels() {
		pregunta.setMinWidth(300);
		pregunta.setMinHeight(60);
		
		si.setMinWidth(150);
		si.setMinHeight(60);
		
		no.setMinWidth(150);
		no.setMinHeight(60);
		
	}
	
	private void centralizarTextoEnLabels() {
		pregunta.setAlignment(Pos.CENTER);
		si.setAlignment(Pos.CENTER);
		no.setAlignment(Pos.CENTER);
	}
	
	private void decorarLabels() {
	
		pregunta.setStyle("-fx-background-color:saddlebrown; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 14px;-fx-font-weight: bold");
		si.setStyle("-fx-background-color:darkgoldenrod; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 14px;-fx-font-weight: bold");
		no.setStyle("-fx-background-color:darkgoldenrod; -fx-border-color:white; -fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 14px;-fx-font-weight: bold");
			
	}
	
	private void establecerFuenteLabels() {
		
		pregunta.setFont(new Font("Arial",14));
		si.setFont(new Font("Arial",14));
		no.setFont(new Font("Arial",14));
	
	}
	

	//GETTERS & SETTERS
	

	public VBox getRoot() {
		return root;
	}

	public void setRoot(VBox root) {
		this.root = root;
	}

	public StackPane getStackDeFondo() {
		return stackDeFondo;
	}

	public void setStackDeFondo(StackPane stackDeFondo) {
		this.stackDeFondo = stackDeFondo;
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

	public FlowPane getFlowDePreguntas() {
		return flowDePreguntas;
	}

	public void setFlowDePreguntas(FlowPane flowDePreguntas) {
		this.flowDePreguntas = flowDePreguntas;
	}

	public Label getPregunta() {
		return pregunta;
	}

	public void setPregunta(Label pregunta) {
		this.pregunta = pregunta;
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

