package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.*;

import java.util.LinkedList;

public class PreguntaVerdaderoFalsoPenalidad extends PreguntaBase {

    public PreguntaVerdaderoFalsoPenalidad(LinkedList<Opcion> opciones) {
        super(opciones);
    }

    @Override
    public void puntuarJugadores(Jugador jugador, Jugador jugador2) {
        Puntaje puntajeDeJugador = this.obtenerPuntajeBaseDelJugador(jugador);
        Puntaje puntajeDeJugador2 =  this.obtenerPuntajeBaseDelJugador(jugador2);

        Multiplicador multiplicador = jugador.obtenerMultiplicador();
        multiplicador.multiplicar(puntajeDeJugador);

        multiplicador = jugador2.obtenerMultiplicador();
        multiplicador.multiplicar(puntajeDeJugador2);

        jugador.sumarPuntos(puntajeDeJugador);
        jugador2.sumarPuntos(puntajeDeJugador2);
    }

    public void calificarRespuesta(RespondeBien calificador){
        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }

    public void calificarRespuesta(RespondeMal calificador) {
        this.puntajeDelJugador.sumarPuntos(new PuntoNegativo());
    }
}
