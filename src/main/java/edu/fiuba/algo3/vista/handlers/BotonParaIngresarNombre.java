package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.vista.ContenedorPreguntaVoF;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonParaIngresarNombre implements EventHandler<ActionEvent> {

    private TextField texto;
    Stage stage;

    public BotonParaIngresarNombre(TextField texto, Stage stage){
        this.texto = texto;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        texto.clear();
        ContenedorPreguntaVoF contenedorPregunta = new ContenedorPreguntaVoF(stage);
        Scene escenaPregunta = new Scene(contenedorPregunta, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());

        stage.setScene(escenaPregunta);
    }

}
