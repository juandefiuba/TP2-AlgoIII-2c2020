package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Preguntas.*;
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
        Kahoot kahoot = Kahoot.Kahoot("./preguntas.json");

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


        //Pregunta M Choice Penalidad
        Opcion opcionMCP1 = new OpcionCorrecta();
        opcionMCP1.setearTexto("Marte");
        Opcion opcionMCP2 = new OpcionIncorrecta();
        opcionMCP2.setearTexto("Plutón");
        Opcion opcionMCP3 = new OpcionIncorrecta();
        opcionMCP3.setearTexto("Cybertron");
        Opcion opcionMCP4 = new OpcionCorrecta();
        opcionMCP4.setearTexto("Venus");
        LinkedList<Opcion> opciones3 = new LinkedList<>();
        opciones3.add(opcionMCP1);
        opciones3.add(opcionMCP2);
        opciones3.add(opcionMCP3);
        opciones3.add(opcionMCP4);
        PreguntaMultipleChoicePenalidad preguntaMultiple = new PreguntaMultipleChoicePenalidad(opciones3);
        preguntaMultiple.setearTexto("Cuales de estos planetas pertenecen a la vía láctea?");
        kahoot.agregarPregunta(preguntaMultiple);


        //Pregunta GroupChoice
        Opcion opcionG1 = new OpcionOrdenada();
        opcionG1.setearTexto("Leche");
        Opcion opcionG2 = new OpcionOrdenada();
        opcionG2.setearTexto("Nafta");
        Opcion opcionG3 = new OpcionOrdenada();
        opcionG3.setearTexto("Gas");
        Opcion opcionG4 = new OpcionOrdenada();
        opcionG4.setearTexto("Manteca");
        LinkedList<Opcion> opciones5 = new LinkedList<>();
        opciones5.add(opcionG1);
        opciones5.add(opcionG2);
        opciones5.add(opcionG3);
        opciones5.add(opcionG4);
        PreguntaGroupChoice preguntaGroupChoice = new PreguntaGroupChoice(opciones5);
        preguntaGroupChoice.setearTexto("Separe en grupos");
        kahoot.agregarPregunta(preguntaGroupChoice);

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
