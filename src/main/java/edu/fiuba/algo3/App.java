package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaOrderedChoice;
import edu.fiuba.algo3.vista.ContenedorBienvenida;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.LinkedList;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Kahoot!");
        stage.setMaximized(false); //Comenzar en modo ventana
        Kahoot kahoot = Kahoot.Kahoot();

 
        //Pregunta OrderedChoice
        Opcion opcionO1 = new OpcionOrdenada();
        opcionO1.setearTexto("1");
        Opcion opcionO2 = new OpcionOrdenada();
        opcionO2.setearTexto("2");
        Opcion opcionO3 = new OpcionOrdenada();
        opcionO3.setearTexto("3");
        Opcion opcionO4 = new OpcionOrdenada();
        opcionO4.setearTexto("4");
        LinkedList<Opcion> opciones4 = new LinkedList<>();
        opciones4.add(opcionO1);
        opciones4.add(opcionO2);
        opciones4.add(opcionO3);
        opciones4.add(opcionO4);
        PreguntaOrderedChoice preguntaOrdered = new PreguntaOrderedChoice(opciones4);
        preguntaOrdered.setearTexto("Marcar de mayor a menor");
        kahoot.agregarPregunta(preguntaOrdered);

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
