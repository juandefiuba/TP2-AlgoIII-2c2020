package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedores.ContenedorBienvenida;
import edu.fiuba.algo3.vista.handlers.botonesOk.MusicaPlay;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Kahoot!");
        stage.setMaximized(false); //Comenzar en modo ventana
        Kahoot kahoot = Kahoot.Kahoot("./preguntas.json");
        int altoPredeterminado = 720;
        int anchoPredeterminado = 1280;

        //PROPIEDADES VENTANA (Ancho x Alto)
        stage.setMinHeight(altoPredeterminado);
        stage.setMinWidth(anchoPredeterminado);
        stage.setMaxHeight(altoPredeterminado);
        stage.setMaxWidth(anchoPredeterminado);

        //CREACIÓN ESCENA PRINCIPAL
        ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida(stage, kahoot);
        Scene escenaBienvenida = new Scene(contenedorBienvenida, anchoPredeterminado, altoPredeterminado);
        stage.setScene(escenaBienvenida);
        stage.sizeToScene();

        stage.show();
        String rutaArchivoMusica = "src/main/java/edu/fiuba/algo3/vista/musica/lobby-music-8bit-edition.wav";

        new MusicaPlay(rutaArchivoMusica).handle(new ActionEvent());
    }

}
