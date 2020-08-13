package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vista.ContenedorPreguntaVoF;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonParaIngresarNombre implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private String nombreJugador;
    private TextField texto;
    Stage stage;

    public BotonParaIngresarNombre(TextField texto, Stage stage, Jugador jugador){
        this.texto = texto;
        this.stage = stage;
        this.jugador = jugador;
        this.nombreJugador = texto.getText();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.nombrar(nombreJugador);

        texto.clear();
        ContenedorPreguntaVoF contenedorPregunta = new ContenedorPreguntaVoF(stage);
        Scene escenaPregunta = new Scene(contenedorPregunta, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());

        stage.setScene(escenaPregunta);
    }

}
