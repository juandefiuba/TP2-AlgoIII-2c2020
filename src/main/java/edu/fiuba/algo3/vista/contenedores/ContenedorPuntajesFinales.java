package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.controlador.SalirDelJuegoHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.Musica;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class ContenedorPuntajesFinales extends BorderPane {

    BarraDeMenu menuBar;
    Kahoot kahoot;

    public ContenedorPuntajesFinales(Stage stage, Kahoot kahoot) {
        this.setMenu(stage);
        this.contenedorCentral(stage, kahoot);
        stage.sizeToScene();
    }

    private void contenedorCentral(Stage stage, Kahoot kahoot) {
        String rutaArchivoFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/sale-banner-II.jpg";
        Image imagen = new Image(rutaArchivoFondo);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        String estiloPuntajeJugador = "-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #FFFFFF; -fx-font-size: 3em ;-fx-text-fill: #000000 ;-fx-font-weight: bold";
        stage.setTitle("Puntajes");
        
        Button botonSalir = new Button("Cerrar");
        botonSalir.setStyle(" -fx-font-size: 3em; -fx-alignment: center");
        botonSalir.setOnAction(new SalirDelJuegoHandler());

        VBox puntajes = new VBox();
        Text titulo = new Text("Puntajes finales:");
        titulo.setStyle("-fx-font-size: 3em ");
        Jugador jugador1 = kahoot.obtenerJugadores().getFirst();
        Jugador jugador2 = kahoot.obtenerJugadores().getLast();
        Button puntajeJugador1 = new Button(jugador1.getNombreJugador() + " consiguió " + jugador1.obtenerPuntos() + " Puntos");
        Button puntajeJugador2 = new Button(jugador2.getNombreJugador() + " consiguió " + jugador2.obtenerPuntos() + " Puntos");
        puntajeJugador1.setStyle(estiloPuntajeJugador);
        puntajeJugador2.setStyle(estiloPuntajeJugador);
        puntajes.getChildren().addAll(titulo, puntajeJugador1, puntajeJugador2);
        puntajes.setAlignment(Pos.CENTER);
        puntajes.setSpacing(20);

        Text mensajeFinal = new Text();

        if (jugador1.obtenerPuntos() == jugador2.obtenerPuntos()){
            mensajeFinal.setText("Empate!");
        } else{
            String nombreGanador;
            if (jugador1.obtenerPuntos() > jugador2.obtenerPuntos()){
                nombreGanador = jugador1.getNombreJugador();
            } else {
                nombreGanador = jugador2.getNombreJugador();
            }
            mensajeFinal.setText("Felicidades " + nombreGanador + "\nGanaste!");
        }

        mensajeFinal.setStyle("-fx-font-size: 3em ");
        mensajeFinal.setTextAlignment(TextAlignment.CENTER);

        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(mensajeFinal, puntajes, botonSalir);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(100);

        this.setCenter(contenedorVertical);

        Musica.musicaPause();
        Musica.musicaPlayYDespuesPlayOtraInfinita("src/main/java/edu/fiuba/algo3/vista/musica/sound-effect-tada.wav", "src/main/java/edu/fiuba/algo3/vista/musica/kool-the-gang-celebration.wav");
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
}