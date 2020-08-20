package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.ContenedorBienvenida;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.file.Paths;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Kahoot!");
        stage.setMaximized(false); //Comenzar en modo ventana
        Kahoot kahoot = Kahoot.Kahoot();
        //PROPIEDADES VENTANA (Ancho x Alto)
        stage.setMinHeight(TamanioDeVentana.altoPredeterminado());
        stage.setMinWidth(TamanioDeVentana.anchoPredeterminado());
        stage.setMaxHeight(TamanioDeVentana.altoPredeterminado());
        stage.setMaxWidth(TamanioDeVentana.anchoPredeterminado());

        //CREACIÓN ESCENA PRINCIPAL
        ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida(stage, kahoot);
        Scene escenaBienvenida = new Scene(contenedorBienvenida, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
        stage.setScene(escenaBienvenida);

        stage.show();
        musica();
    }

    MediaPlayer mediaPlayer;
    public void musica() {
        String rutaArchivoMusica = "src/main/java/edu/fiuba/algo3/vista/musica/lobby-music-8bit-edition.wav";
        Media media = new Media(Paths.get(rutaArchivoMusica).toUri().toString());
        mediaPlayer = new MediaPlayer(media);

        //LOOP MÚSICA
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));

        mediaPlayer.play();
    }
}
