package interfaces;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Inicio {
	private StackPane root = new StackPane();

	private ImageView fondo = new ImageView(new Image("/imagenes/fondoInicio.jpg"));

	private VBox VBoxBienvenida = new VBox(20);

	private Label labelGenioPolitecnico = new Label("Genio Politecnico");

	private ImageView imagenGenio = new ImageView(new Image("/imagenes/genioInicio.png"));

	private Label labelPensar = new Label("Piense en un animal, tratare de adivinarlo");

	private Button jugar = new Button("Jugar");

	public Inicio() {
		
		organizarElementos();
		centralizarNodos();
		ajustarTamanoImagenes();
		colorearTextoLabels();
		establecerFuenteLabels();
		decorarBoton();
		establecerOpacidad();
		alinearLabels();
		ajustarTamanoLabels();
	
	}

	//METODOS

	private void organizarElementos() {

		root.getChildren().addAll(fondo, VBoxBienvenida);

		VBoxBienvenida.getChildren().addAll(labelGenioPolitecnico,imagenGenio,labelPensar,jugar);
	}

	private void centralizarNodos() {
		VBoxBienvenida.setAlignment(Pos.CENTER);
	}
	
	private void ajustarTamanoImagenes() {
		imagenGenio.setFitHeight(200);
		imagenGenio.setFitWidth(100);
		fondo.setFitHeight(400);
		fondo.setFitWidth(300);
	}
	
	private void colorearTextoLabels() {
		labelGenioPolitecnico.setStyle("-fx-text-fill:white;-fx-font-weight:bold;-fx-background-color:deeppink;-fx-border-color:bisque");
		labelPensar.setStyle("-fx-text-fill:white;-fx-font-weight:bold;-fx-background-color:deeppink;-fx-border-color:bisque");
	
	}
	private void establecerFuenteLabels() {
		labelGenioPolitecnico.setFont(new Font("Tahoma",14));
		labelPensar.setFont(new Font("Tahoma",14));
	}
	private void decorarBoton() {
		jugar.setStyle("-fx-font-weight:bold;-fx-base:royalblue;-fx-font-size:14;-fx-text-fill:white;-fx-border-color:aliceblue;-fx-font-family:Tahoma");
	}
	private void establecerOpacidad() {
		imagenGenio.setOpacity(0.8);
		labelPensar.setOpacity(0.85);
		labelGenioPolitecnico.setOpacity(0.85);
	}
	private void alinearLabels() {
		labelGenioPolitecnico.setAlignment(Pos.CENTER);
		labelPensar.setAlignment(Pos.CENTER);
	}
	private void ajustarTamanoLabels() {
		labelGenioPolitecnico.setMinWidth(305);
		labelPensar.setMinWidth(305);
		
	}
	




	//GETTERS & SETTERS

	public StackPane getRoot() {
		return root;
	}

	public void setRoot(StackPane root) {
		this.root = root;
	}

	public ImageView getFondo() {
		return fondo;
	}

	public void setFondo(ImageView fondo) {
		this.fondo = fondo;
	}

	public VBox getVBoxBienvenida() {
		return VBoxBienvenida;
	}

	public void setVBoxBienvenida(VBox vBoxBienvenida) {
		VBoxBienvenida = vBoxBienvenida;
	}

	public Label getLabelGenioPolitecnico() {
		return labelGenioPolitecnico;
	}

	public void setLabelGenioPolitecnico(Label labelGenioPolitecnico) {
		this.labelGenioPolitecnico = labelGenioPolitecnico;
	}

	public ImageView getImagenGenio() {
		return imagenGenio;
	}

	public void setImagenGenio(ImageView imagenGenio) {
		this.imagenGenio = imagenGenio;
	}

	public Label getLabelPensar() {
		return labelPensar;
	}

	public void setLabelPensar(Label labelPensar) {
		this.labelPensar = labelPensar;
	}

	public Button getJugar() {
		return jugar;
	}

	public void setJugar(Button jugar) {
		this.jugar = jugar;
	}




}
