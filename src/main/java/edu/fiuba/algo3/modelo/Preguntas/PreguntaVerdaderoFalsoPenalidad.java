package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.*;

import java.util.LinkedList;

public class PreguntaVerdaderoFalsoPenalidad extends Pregunta {

    public PreguntaVerdaderoFalsoPenalidad(LinkedList<Opcion> opciones) {
        super(opciones);
    }

    public Puntaje puntuarJugador(Jugador jugador){
        Puntaje puntajeDelJugador = super.puntuarJugador(jugador);
        Multiplicador multiplicador = jugador.obtenerMultiplicador();
        multiplicador.multiplicar(puntajeDelJugador);
        this.puntajesDeLosJugadores.put(jugador, puntajeDelJugador);
        return puntajeDelJugador;
    }


    public void calificarRespuesta(Opcion opcion){
        opcion.validarOpcion(this);
    }

    public void calificarRespuesta(RespondeBien calificador){
        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }

    public void calificarRespuesta(RespondeMal calificador) {
        this.puntajeDelJugador.sumarPuntos(new PuntoNegativo());
    }
}
