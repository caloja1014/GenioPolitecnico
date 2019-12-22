package interfaces;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Inicio {
	private StackPane root = new StackPane();

	private ImageView fondo = new ImageView(new Image("/imagenes/fondoDePrueba.png"));

	private VBox VBoxBienvenida = new VBox(20);

	private Label labelGenioPolitecnico = new Label("Genio Politécnico");

	private ImageView imagenGenio = new ImageView(new Image("/imagenes/genioInicio.png"));

	private Label labelPensar = new Label("Piense en un animal, trataré de adivinarlo");

	private Button jugar = new Button("Jugar");

	public Inicio() {
		organizarElementos();
		centralizarNodos();
		ajustarTamanoImagenes();

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
		imagenGenio.setFitHeight(100);
		imagenGenio.setFitWidth(100);
		fondo.setFitHeight(400);
		fondo.setFitWidth(300);
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
