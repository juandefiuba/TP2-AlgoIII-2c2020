package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Multiplicador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.RespondeBien;
import edu.fiuba.algo3.modelo.Opcion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PreguntaMultipleChoicePenalidad extends Pregunta {

    public PreguntaMultipleChoicePenalidad(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
    }

    public Puntaje puntuarJugador(Jugador jugador) {
        Puntaje puntajeDelJugador = super.puntuarJugador(jugador);
        Multiplicador multiplicador = jugador.obtenerMultiplicador();
        multiplicador.multiplicar(puntajeDelJugador);
        this.puntajesDeLosJugadores.put(jugador, puntajeDelJugador);
        return puntajeDelJugador;
    }

    @Override
    public void calificarRespuesta(RespondeBien calificador) {

        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }

    @Override
    public void calificarRespuesta(RespondeMal calificador) {

        this.puntajeDelJugador.sumarPuntos(new PuntoNegativo());
    }
}
