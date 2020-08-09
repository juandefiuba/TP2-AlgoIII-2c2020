package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Puntos.*;
import java.util.LinkedList;

public class PreguntaVerdaderoFalso extends Pregunta{

    public PreguntaVerdaderoFalso(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
    }

    public void calificarOpcion(Opcion opcion){
        opcion.validarOpcion(this);
    }

    public void calificarOpcion(OpcionCorrecta opcion){
        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }

    public void calificarOpcion(OpcionIncorrecta opcion){
        this.puntajeDelJugador = new PuntajeNeutro();
    }
}
