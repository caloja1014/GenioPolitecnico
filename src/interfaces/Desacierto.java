package interfaces;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Desacierto {
	private VBox root = new VBox();
	
	private StackPane stackPaneFondo = new StackPane();
	
	private ImageView fondo = new ImageView(new Image("/imagenes/fondoPregunta.jpg"));
	
	private ImageView imagenGenio = new ImageView(new Image("/imagenes/genioDesacierto.jpg"));
	
	private FlowPane flowAyudarPrediccion = new FlowPane();
	
	private Label labelAyudame = new Label("¡Ayúdame a mejorar mi predicción!");
	
	private Label labelPensando = new Label("¿Qué animal estabas pensando?");
	
	private TextField textFieldPensando = new TextField();
	
	private Label labelPregunta = new Label("Escribe una pregunta que me permita diferenciar\n"+ "entre animal X y Y");
	
	private TextField textFieldPregunta = new TextField();
	
	private Label labelSiNo = new Label("¿Para un X, la respuesta a la pregunta: W?,\n es sí o no?");
	
	private RadioButton si = new RadioButton("Sí");
	
	private RadioButton no = new RadioButton("No");
	
	private Button siguiente = new Button("Siguiente");
	
	
	public Desacierto() {
		organizarElementos();
		ajustarTamanoNodos();
		centralizarNodos();
		decorarLabels();
		colocarPromptsEnTextFields();
		
		
	}
	private void organizarElementos() {
		root.getChildren().addAll(stackPaneFondo,flowAyudarPrediccion);
		stackPaneFondo.getChildren().addAll(fondo,imagenGenio);
		flowAyudarPrediccion.getChildren().addAll(labelAyudame,labelPensando,textFieldPensando,labelPregunta,textFieldPregunta,labelSiNo,si,no,siguiente);
		
		
	}
	
	private void ajustarTamanoNodos() {
		fondo.setFitWidth(300);
		fondo.setFitHeight(150);
		
		imagenGenio.setFitHeight(120);
		imagenGenio.setFitWidth(120);
		
		labelAyudame.setMinHeight(31.25);
		labelAyudame.setMinWidth(300);
		
		labelPensando.setMinHeight(31.25);
		labelPensando.setMinWidth(300);
		
		textFieldPensando.setMinHeight(31.25);
		textFieldPensando.setMinWidth(300);
		
		
		labelPregunta.setMinHeight(31.25);
		labelPregunta.setMinWidth(300);
		
		textFieldPregunta.setMinHeight(31.25);
		textFieldPregunta.setMinWidth(300);
		
		labelSiNo.setMinWidth(300);
		labelSiNo.setMinHeight(31.25);
		
		si.setMinWidth(150);
		no.setMinWidth(150);
		
		si.setMinHeight(31.25);
		no.setMinHeight(31.25);
		
	
		siguiente.setMinHeight(31.25);
		
	}
	
	private void centralizarNodos() {
		labelAyudame.setAlignment(Pos.CENTER);
		
		labelPensando.setAlignment(Pos.CENTER_LEFT);
		
		labelPregunta.setAlignment(Pos.CENTER_LEFT);
		
		labelSiNo.setAlignment(Pos.CENTER_LEFT);
		
		siguiente.setAlignment(Pos.CENTER);
		
	}
	
	private void colocarPromptsEnTextFields() {
		
		textFieldPensando.setPromptText("Coloque aquí el nombre del animal");
		textFieldPregunta.setPromptText("Coloque aquí la pregunta");
		
	}
	
	private void decorarLabels() {
		labelAyudame.setStyle("-fx-background-color:darkred; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 12px;-fx-font-weight:bold");
		labelPensando.setStyle("-fx-background-color:darkgoldenrod; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 12px;-fx-font-weight:bold");
		labelPregunta.setStyle("-fx-background-color:darkgoldenrod; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 12px;-fx-font-weight:bold");
		labelSiNo.setStyle("-fx-background-color:darkgoldenrod; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 12px;-fx-font-weight:bold");
	}
	
	

	public VBox getRoot() {
		return root;
	}

	public void setRoot(VBox root) {
		this.root = root;
	}

	public StackPane getStackPaneFondo() {
		return stackPaneFondo;
	}

	public void setStackPaneFondo(StackPane stackPaneFondo) {
		this.stackPaneFondo = stackPaneFondo;
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

	public FlowPane getFlowAyudarPrediccion() {
		return flowAyudarPrediccion;
	}

	public void setFlowAyudarPrediccion(FlowPane flowAyudarPrediccion) {
		this.flowAyudarPrediccion = flowAyudarPrediccion;
	}

	public Label getLabelAyudame() {
		return labelAyudame;
	}

	public void setLabelAyudame(Label labelAyudame) {
		this.labelAyudame = labelAyudame;
	}

	public Label getLabelPensando() {
		return labelPensando;
	}

	public void setLabelPensando(Label labelPensando) {
		this.labelPensando = labelPensando;
	}

	public TextField getTextFieldPensando() {
		return textFieldPensando;
	}

	public void setTextFieldPensando(TextField textFieldPensando) {
		this.textFieldPensando = textFieldPensando;
	}

	public Label getLabelPregunta() {
		return labelPregunta;
	}

	public void setLabelPregunta(Label labelPregunta) {
		this.labelPregunta = labelPregunta;
	}

	public TextField getTextFieldPregunta() {
		return textFieldPregunta;
	}

	public void setTextFieldPregunta(TextField textFieldPregunta) {
		this.textFieldPregunta = textFieldPregunta;
	}
	
	
}
