package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.handlers.CambiarDeEscena;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorPaseDePantalla extends BorderPane {
    private final Kahoot kahoot;
    private final Stage stage;
    private final boolean yaRespondioUnJugador;

    public ContenedorPaseDePantalla(Kahoot kahoot, Stage stage, boolean yaRespondioUnJugador) {
        this.kahoot = kahoot;
        this.stage = stage;
        this.yaRespondioUnJugador = yaRespondioUnJugador;
        this.contenedorCentral();
    }

    public void contenedorCentral(){
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Text texto = new Text("Turno de " + kahoot.obtenerJugadorActual().getNombreJugador() + " Puntaje: " + kahoot.obtenerJugadorActual().obtenerPuntos());
        setStyle(" -fx-font-size: 3em");

        Button boton = new Button("Ok");
        VBox contenedorPrincipal = new VBox();
        boton.setOnAction(new CambiarDeEscena(stage, kahoot, yaRespondioUnJugador));

        contenedorPrincipal.getChildren().addAll(texto, boton);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setSpacing(200);
        boton.requestFocus();
        this.setCenter(contenedorPrincipal);
    }
}
