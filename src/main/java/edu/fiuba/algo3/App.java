package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.contenedores.ContenedorBienvenida;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static edu.fiuba.algo3.vista.Musica.musicaPlay;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Kahoot!");
        stage.setMaximized(false); //Comenzar en modo ventana
        Kahoot kahoot = Kahoot.Kahoot("./preguntas.json");

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
        String rutaArchivoMusica = "src/main/java/edu/fiuba/algo3/vista/musica/lobby-music-8bit-edition.wav";

        musicaPlay(rutaArchivoMusica);
    }

}
