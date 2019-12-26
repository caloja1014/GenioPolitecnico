package interfaces;

import arbol.BT;
import arbol.Node;
import geniopolitecnico.GenioPolitecnico;
import java.util.Stack;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Preguntas {

    private Stack<Node<String>> pila = new Stack<>();
    private BT<String> arbol = GenioPolitecnico.arbol;
    private boolean cerrarStage;
    private Node<String> raiz = arbol.getRoot();
    private VBox root = new VBox();

    private Pane stackDeFondo = new Pane();

    private ImageView fondo = new ImageView(new Image("/imagenes/fondoPregunta.jpg"));

    private ImageView imagenGenio = new ImageView(new Image("/imagenes/genioPreguntas.png"));

    private FlowPane flowDePreguntas = new FlowPane();
    private String p;
    private Label pregunta;

    private Label si = new Label("Si");

    private Label no = new Label("No");

    private Label regresar = new Label("Regresar");

    public Preguntas() {
        organizarElementos();
        ajustarTamanoImagenes();
        ajustarTamanoLabels();
        centralizarTextoEnLabels();
        decorarLabels();
        establecerFuenteLabels();
    }

    private void organizarElementos() {
        iterarPreguntas();
        root.getChildren().addAll(stackDeFondo, flowDePreguntas);
        stackDeFondo.getChildren().addAll(fondo, imagenGenio);
        imagenGenio.setX(75);
        imagenGenio.setY(75);
        flowDePreguntas.getChildren().addAll(pregunta, si, no);
    }

    private void iterarPreguntas() {
        pregunta = new Label(raiz.getData());
        si.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                pila.push(raiz);
                if (raiz.isHoja()) {

                    Acierto acierto = new Acierto();

                    Scene escena = new Scene(acierto.getRoot(), 300, 400);
                    GenioPolitecnico.stage.setScene(escena);

                } else {
                    p = raiz.getData();
                    raiz = raiz.getLeft();
                    raiz.getLeft();
                    System.out.println(raiz.isIsLeft());

                    Platform.runLater(() -> pregunta.setText(raiz.getData()));

                }
                regresar();
            }

        });
        no.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                pila.push(raiz);
                if (raiz.isHoja()) {

                    Desacierto desacierto = new Desacierto(raiz, p);

                    Scene escena = new Scene(desacierto.getRoot(), 300, 400);
                    GenioPolitecnico.stage.setScene(escena);

                } else {
                    p = raiz.getData();
                    raiz = raiz.getRight();
                    System.out.println(raiz.isIsLeft());

                    Platform.runLater(() -> pregunta.setText(raiz.getData()));

                }
                regresar();
            }

        });
    }

    public void regresar() {
        if (!stackDeFondo.getChildren().contains(regresar)) {
            stackDeFondo.getChildren().add(regresar);
        }
        regresar.setLayoutX(225);
        regresar.setLayoutY(230);
        regresar.setAlignment(Pos.CENTER);
        regresar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (!pila.isEmpty()) {
                    raiz = pila.pop();

                    Platform.runLater(() -> pregunta.setText(raiz.getData()));
                    if (raiz == arbol.getRoot()) {
                        stackDeFondo.getChildren().remove(regresar);
                    }
                }

            }

        });

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
        si.setId("si");
        
        no.setMinWidth(150);
        no.setMinHeight(60);
        no.setId("no");
        
        regresar.setMinWidth(75);
        regresar.setMinHeight(40);

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
        regresar.setStyle("-fx-background-color:beige; -fx-border-color:white; -fx-text-fill:brown;-fx-font-family:Tahoma;-fx-font-size: 14px;-fx-font-weight: bold");

    }

    private void establecerFuenteLabels() {

        pregunta.setFont(new Font("Arial", 14));
        si.setFont(new Font("Arial", 14));
        no.setFont(new Font("Arial", 14));
        regresar.setFont(new Font("Arial", 10));
    }

    //GETTERS & SETTERS
    public VBox getRoot() {
        return root;
    }

    public void setRoot(VBox root) {
        this.root = root;
    }

    public Pane getStackDeFondo() {
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

    public boolean isCerrarStage() {
        return cerrarStage;
    }

}
