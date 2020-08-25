package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.controlador.SalirDelJuegoHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.Musica;
import edu.fiuba.algo3.vista.handlers.SeleccionarOpcionGroupChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
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

        String estiloPuntajeJugador = "-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #FFFFFF; -fx-font-size: 3em ;-fx-text-fill: #000000";
        stage.setTitle("Puntajes");
        
        Button botonSalir = new Button("Cerrar");
        botonSalir.setStyle(" -fx-font-size: 3em; -fx-alignment: center");
        botonSalir.setOnAction(new SalirDelJuegoHandler());

        HBox puntajes = new HBox();
        Jugador jugador1 = kahoot.obtenerJugadores().getFirst();
        Jugador jugador2 = kahoot.obtenerJugadores().getLast();
        Button puntajeJugador1 = new Button(jugador1.getNombreJugador() + ": " + jugador1.obtenerPuntos());
        Button puntajeJugador2 = new Button(jugador2.getNombreJugador() + ": " + jugador2.obtenerPuntos());
        puntajeJugador1.setStyle(estiloPuntajeJugador);
        puntajeJugador2.setStyle(estiloPuntajeJugador);
        puntajes.getChildren().addAll(puntajeJugador1, puntajeJugador2);
        puntajes.setAlignment(Pos.CENTER);
        puntajes.setSpacing(20);
        String nombreGanador;

        if(jugador1.obtenerPuntos() > jugador2.obtenerPuntos()) {
            nombreGanador = jugador1.getNombreJugador();
        } else {
            if(jugador1.obtenerPuntos() < jugador2.obtenerPuntos()) {
                nombreGanador = jugador2.getNombreJugador();
            } else {
                nombreGanador = "Ambos";
            }
        }

        Text titulo = new Text("Ganador: "+ nombreGanador);
        titulo.setStyle("-fx-font-size: 3em ");

        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(titulo, puntajes, botonSalir);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(100);

        this.setCenter(contenedorVertical);

        Musica.musicaStop();
        String rutaArchivoMusica = "src/main/java/edu/fiuba/algo3/vista/musica/kool-the-gang-celebration.wav";
        Musica.musicaPlay(rutaArchivoMusica);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    void agregarBotonOpcion(Stage stage, Opcion opcion, VBox opcionesDadas, VBox grupo1, VBox grupo2, Button pasarAGrupo1, Button pasarAGrupo2, Button botonOk){
        Button botonOpcion = new Button(opcion.obtenerTexto());
        opcionesDadas.getChildren().add(botonOpcion);
        botonOpcion.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(100,50);
        botonOpcion.setOnAction(new SeleccionarOpcionGroupChoice(botonOpcion, pasarAGrupo1, pasarAGrupo2, grupo1, grupo2, opcionesDadas, botonOk, opcion, kahoot));
    }

}