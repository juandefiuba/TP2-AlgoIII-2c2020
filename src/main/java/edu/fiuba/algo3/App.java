package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.Escena;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedores.ContenedorBienvenida;
import edu.fiuba.algo3.vista.handlers.MusicaPlayInfinito;
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
        int altoPredeterminado = TamanioDeVentana.altoPredeterminado();
        int anchoPredeterminado = TamanioDeVentana.anchoPredeterminado();

        //PROPIEDADES VENTANA (Ancho x Alto)
        stage.setMinHeight(altoPredeterminado);
        stage.setMinWidth(anchoPredeterminado);
        //stage.setMaxHeight(altoPredeterminado);
        //stage.setMaxWidth(anchoPredeterminado);

        //CREACIÓN ESCENA PRINCIPAL
        stage.show();
        ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida(stage, kahoot);
        Scene escenaBienvenida = new Scene(contenedorBienvenida, anchoPredeterminado, altoPredeterminado);
        stage.setScene(escenaBienvenida);
        Escena.setearEscenaActual(escenaBienvenida);

        String rutaArchivoMusica = "src/main/java/edu/fiuba/algo3/vista/musica/lobby.wav";

        new MusicaPlayInfinito(rutaArchivoMusica).handle(new ActionEvent());
    }

}
