package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.CambiadorImagenFondoEntreTurnos;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.handlers.CambiarDeEscena;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
        Image imagen = new Image(CambiadorImagenFondoEntreTurnos.getRutaFondo());
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Text texto = new Text("Turno de " + kahoot.obtenerJugadorActual().getNombreJugador() + ".\nTienes " + kahoot.obtenerJugadorActual().obtenerPuntos() + " Puntos");
        texto.setStyle(" -fx-font-size: 50px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ffffff ;-fx-stroke-width: 2px");
        texto.setTextAlignment(TextAlignment.CENTER);

        Button boton = new Button("Ok");
        boton.setStyle(" -fx-font-size: 3em");
        VBox contenedorPrincipal = new VBox();
        boton.setOnAction(new CambiarDeEscena(stage, kahoot, yaRespondioUnJugador));

        contenedorPrincipal.getChildren().addAll(texto, boton);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setSpacing(300);
        boton.requestFocus();
        this.setCenter(contenedorPrincipal);
    }
}
