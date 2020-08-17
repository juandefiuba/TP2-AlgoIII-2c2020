package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Exclusividades.Parcial.ExclusividadParcial;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeNulo;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;

import java.util.LinkedList;

public class PreguntaMultipleChoiceParcial extends PreguntaBase{

    public PreguntaMultipleChoiceParcial(LinkedList<Opcion> opciones) {
        super(opciones);
    }

    @Override
    public void puntuarJugadores(Jugador jugador, Jugador jugador2) {
        Puntaje puntajeJugador = this.obtenerPuntajeBaseDelJugador(jugador);
        Puntaje puntajeJugador2 = this.obtenerPuntajeBaseDelJugador(jugador2);

        ExclusividadParcial exclusividad = jugador.obtenerExclusividad();
        ExclusividadParcial exclusividad2 = jugador2.obtenerExclusividad();

        ExclusividadCompuesta exclusividadTotal = exclusividad2.componerExclusividad(exclusividad);

        exclusividadTotal.aplicarExclusividadAPuntajes(puntajeJugador, puntajeJugador2);

        jugador.sumarPuntos(puntajeJugador);
        jugador2.sumarPuntos(puntajeJugador2);
    }

    @Override
    public void calificarRespuesta(RespondeBien calificador) {
        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }

    @Override
    public void calificarRespuesta(RespondeMal calificador){
        this.puntajeDelJugador = new PuntajeNulo();
    }

}
