package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;

import java.util.LinkedList;

public class PreguntaMultipleChoicePenalidad extends PreguntaBase {

    public PreguntaMultipleChoicePenalidad(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
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

    @Override
    public void calificarRespuesta(RespondeBien calificador) {

        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }

    @Override
    public void calificarRespuesta(RespondeMal calificador) {

        this.puntajeDelJugador.sumarPuntos(new PuntoNegativo());
    }


}
