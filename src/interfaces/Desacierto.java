package interfaces;

import arbol.Node;
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
import geniopolitecnico.GenioPolitecnico;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class Desacierto {

    private VBox root = new VBox();

    private StackPane stackPaneFondo = new StackPane();

    private ImageView fondo = new ImageView(new Image("/imagenes/fondoPregunta.jpg"));

    private ImageView imagenGenio = new ImageView(new Image("/imagenes/genioDesacierto.png"));

    private VBox flowAyudarPrediccion = new VBox();

    private Label labelAyudame = new Label("Ayudame a mejorar mi prediccion!");

    private Label labelPensando = new Label("Que animal estabas pensando?");

    private TextField textFieldPensando = new TextField();

    private String x, y;

    private Label labelPregunta = new Label("");
    private TextField textFieldPregunta = new TextField();

    private Label labelSiNo = new Label("");

    ToggleGroup seleccion = new ToggleGroup();

    private Button guardar = new Button("Guardar");

    RadioButton si = new RadioButton("Si");
    RadioButton no = new RadioButton("No");

    private Node<String> parent;
    private String p;

    public Desacierto(Node<String> parent, String p) {
        this.p = p;
        this.parent = parent;
        organizarElementos();
        ajustarTamanoNodos();
        centralizarNodos();
        decorarLabels();

        colocarPromptsEnTextFields();
        si.setToggleGroup(seleccion);
        no.setToggleGroup(seleccion);

    }

    private void organizarElementos() {
        root.getChildren().addAll(stackPaneFondo, flowAyudarPrediccion);
        stackPaneFondo.getChildren().addAll(fondo, imagenGenio);
        actualizarRoot();

    }

    public void cambiarVentana() {
        Preguntas preguntas = new Preguntas();
        Scene escena = new Scene(preguntas.getRoot(), 300, 400);
        GenioPolitecnico.stage.setScene(escena);
    }

    public void actualizarRoot() {
        Button siguiente = new Button("Siguiente");
        siguiente.setStyle("-fx-font-weight:bold;-fx-base:brown;-fx-font-size:14;-fx-text-fill:white;-fx-border-color:aliceblue;-fx-font-family:Tahoma");
        StackPane bot=new StackPane(siguiente);
        bot.setPadding(new Insets(5,0,5,0));
        flowAyudarPrediccion.getChildren().addAll(labelAyudame, labelPensando, textFieldPensando, bot);
        flowAyudarPrediccion.setPrefSize(300,400);
        flowAyudarPrediccion.setAlignment(Pos.CENTER);
        siguiente.setOnAction(e -> {
            if (textFieldPensando.getText().length()==0) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Existen campos nulos");
                alerta.setContentText("Por favor llene todo los campos");
                alerta.showAndWait();

            } else {
                avanzarInformacion();
            }

        });

    }

    public void avanzarInformacion() {
        x = parent.getData();
        y = textFieldPensando.getText();
        
        labelPregunta.setText("Escribe una pregunta que me permita diferenciar " + "entre " + x + " y " + y);
        labelPregunta.setWrapText(true);
        labelSiNo.setText("Para un " + y + ", la respuesta a la pregunta: ,es si o no?");
        labelSiNo.setWrapText(true);
        flowAyudarPrediccion.getChildren().clear();
        flowAyudarPrediccion.setPrefSize(300,300);
        //contenedor para los optionButton
        HBox opciones=new HBox(si,no);
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(50);
        opciones.setPadding(new Insets(5,0,5,0));
        //Hasta aqui
        fondo.setFitWidth(300);
        fondo.setFitHeight(175);

        imagenGenio.setFitHeight(150);
        imagenGenio.setFitWidth(150);
        flowAyudarPrediccion.getChildren().addAll(labelPregunta, textFieldPregunta, labelSiNo,opciones, guardar);
        textFieldPregunta.setOnKeyTyped(e -> {

            String w = textFieldPregunta.getText();
            labelSiNo.setText("Para un " + y + ", la respuesta a la pregunta: " + w + "?,es si o no?");
            labelSiNo.setWrapText(true);
        });
        guardar.setOnAction(e -> {
            if (textFieldPregunta.getText().length()==0 || seleccion.getSelectedToggle() == null) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Existen campos nulos");
                alerta.setContentText("Por favor llene todo los campos");
                alerta.showAndWait();

            } else {
                String escogido = ((ToggleButton) seleccion.getSelectedToggle()).getText();
                addPreguntaArbol(parent.getData(), escogido);
                Acierto dialogo=new Acierto();
                dialogo.getLabelAdivinar().setText("Gracias, he aprendido algo nuevo!");
                Scene escena = new Scene(dialogo.getRoot(), 300, 400);
                GenioPolitecnico.stage.setScene(escena);
                
            }
        });

    }

    private void ajustarTamanoNodos() {       
    
        fondo.setFitWidth(300);
        fondo.setFitHeight(250);

        imagenGenio.setFitHeight(200);
        imagenGenio.setFitWidth(200);

        labelAyudame.setMinHeight(36);
        labelAyudame.setMinWidth(300);

        labelPensando.setMinHeight(36);
        labelPensando.setMinWidth(300);

        textFieldPensando.setMinHeight(35);
        textFieldPensando.setMinWidth(300);

        labelPregunta.setPrefSize(300,60);

        textFieldPregunta.setMinHeight(35);
        textFieldPregunta.setMinWidth(300);

        labelSiNo.setPrefSize(300,70);
        
      }

    private void centralizarNodos() {
        labelAyudame.setAlignment(Pos.CENTER);

        labelPensando.setAlignment(Pos.CENTER);

        labelPregunta.setAlignment(Pos.CENTER_LEFT);

        labelSiNo.setAlignment(Pos.CENTER_LEFT);
    }

    private void colocarPromptsEnTextFields() {

        textFieldPensando.setPromptText("Coloque aqui el nombre del animal");
        textFieldPregunta.setPromptText("Coloque aqui la pregunta");

    }

    private void decorarLabels() {
        labelAyudame.setStyle("-fx-background-color:darkred; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 12px;-fx-font-weight:bold");
        labelPensando.setStyle("-fx-background-color:darkgoldenrod; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 12px;-fx-font-weight:bold");
        labelPregunta.setStyle("-fx-background-color:darkgoldenrod; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 12px;-fx-font-weight:bold");
        labelSiNo.setStyle("-fx-background-color:darkgoldenrod; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 12px;-fx-font-weight:bold");
        flowAyudarPrediccion.setStyle("-fx-background-color:beige; -fx-border-color:white;-fx-text-fill:white;-fx-font-family:Tahoma;-fx-font-size: 12px");
        guardar.setStyle("-fx-font-weight:bold;-fx-base:brown;-fx-font-size:14;-fx-text-fill:white;-fx-border-color:aliceblue;-fx-font-family:Tahoma");
    }

    public void addPreguntaArbol(String raiz, String s) {
        boolean isLeft = GenioPolitecnico.arbol.remove(raiz);

        //System.out.println(" separacion          "+"esto es p"+p+"  esto es raiz"+raiz);
        //System.out.println("el boolean es:  "+isLeft);
        if (!isLeft) {
            if (s.equals("Si")) {
                GenioPolitecnico.arbol.addRight(textFieldPregunta.getText(), p);
                GenioPolitecnico.arbol.addLeft(textFieldPensando.getText(), textFieldPregunta.getText());
                GenioPolitecnico.arbol.addRight(raiz, textFieldPregunta.getText());
            } else {
                GenioPolitecnico.arbol.addRight(textFieldPregunta.getText(), p);
                GenioPolitecnico.arbol.addRight(textFieldPensando.getText(), textFieldPregunta.getText());
                GenioPolitecnico.arbol.addLeft(raiz, textFieldPregunta.getText());
            }
        } else {
            if (s.equals("Si")) {
                GenioPolitecnico.arbol.addLeft(textFieldPregunta.getText(), p);
                GenioPolitecnico.arbol.addLeft(textFieldPensando.getText(), textFieldPregunta.getText());
                GenioPolitecnico.arbol.addRight(raiz, textFieldPregunta.getText());
            } else {
                GenioPolitecnico.arbol.addLeft(textFieldPregunta.getText(), p);
                GenioPolitecnico.arbol.addRight(textFieldPensando.getText(), textFieldPregunta.getText());
                GenioPolitecnico.arbol.addLeft(raiz, textFieldPregunta.getText());
            }
        }
        //GenioPolitecnico.arbol.posOrden();
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

    public VBox getFlowAyudarPrediccion() {
        return flowAyudarPrediccion;
    }

    public void setFlowAyudarPrediccion(VBox flowAyudarPrediccion) {
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
