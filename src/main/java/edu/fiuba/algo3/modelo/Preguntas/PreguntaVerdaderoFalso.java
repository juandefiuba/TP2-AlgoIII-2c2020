package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.RespondeBien;
import edu.fiuba.algo3.modelo.Opcion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntos.*;
import java.util.LinkedList;

public class PreguntaVerdaderoFalso extends Pregunta{

    public PreguntaVerdaderoFalso(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
    }

    public void calificarRespuesta(Opcion opcion){
        opcion.validarOpcion(this);
    }

    public void calificarRespuesta(RespondeBien calificador){
        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }

    public void calificarRespuesta(RespondeMal calificador){
        this.puntajeDelJugador = new PuntajeNeutro();
    }
}
