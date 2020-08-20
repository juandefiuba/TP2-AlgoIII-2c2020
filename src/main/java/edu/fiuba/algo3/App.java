package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoiceClasico;
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
/*
        //Pregunta VoF
        Opcion opcionVof = new OpcionCorrecta();
        opcionVof.setearTexto("Verdadero");
        Opcion OpcionVof2 = new OpcionIncorrecta();
        OpcionVof2.setearTexto("Falso");
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcionVof);
        opciones.add(OpcionVof2);
        PreguntaVerdaderoFalso preguntaVoF = new PreguntaVerdaderoFalso(opciones);
        preguntaVoF.setearTexto("El Everest es la montaña más alta?");
        kahoot.agregarPregunta(preguntaVoF);



        //Pregunta VoF con penalidad
        Opcion opcionVofP1 = new OpcionCorrecta();
        opcionVofP1.setearTexto("Verdadero");
        Opcion opcionVofP2 = new OpcionIncorrecta();
        opcionVofP2.setearTexto("Falso");
        LinkedList<Opcion> opciones1 = new LinkedList<>();
        opciones1.add(opcionVofP1);
        opciones1.add(opcionVofP2);
        PreguntaVerdaderoFalsoPenalidad preguntaVofPenalidad = new PreguntaVerdaderoFalsoPenalidad(opciones1);
        preguntaVofPenalidad.setearTexto("Deben entregarse al pánico?");
        kahoot.agregarPregunta(preguntaVofPenalidad);

*/
        //Pregunta M Choice Clasico
        Opcion opcionMCC1 = new OpcionCorrecta();
        opcionMCC1.setearTexto("Zeus");
        Opcion opcionMCC2 = new OpcionIncorrecta();
        opcionMCC2.setearTexto("Minerva");
        Opcion opcionMCC3 = new OpcionIncorrecta();
        opcionMCC3.setearTexto("Júpiter");
        Opcion opcionMCC4 = new OpcionIncorrecta();
        opcionMCC4.setearTexto("Venus");
        Opcion opcionMCC5 = new OpcionCorrecta();
        opcionMCC5.setearTexto("Hades");
        LinkedList<Opcion> opciones2 = new LinkedList<>();
        opciones2.add(opcionMCC1);
        opciones2.add(opcionMCC2);
        opciones2.add(opcionMCC3);
        opciones2.add(opcionMCC4);
        opciones2.add(opcionMCC5);
        PreguntaMultipleChoiceClasico preguntaMultipleClasico = new PreguntaMultipleChoiceClasico(opciones2);
        preguntaMultipleClasico.setearTexto("Cuales dioses son griegos?");
        kahoot.agregarPregunta(preguntaMultipleClasico);

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
