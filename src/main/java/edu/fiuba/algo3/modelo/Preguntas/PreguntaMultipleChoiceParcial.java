package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeNulo;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
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

        Exclusividad exclusividad = jugador.obtenerExclusividad();
        Exclusividad exclusividad2 = jugador2.obtenerExclusividad();

        Exclusividad exclusividadParcial1 = exclusividad2.componerExclusividad(exclusividad);

        EstadoExclusividad exclusividadParcial2 = puntajeJugador.emparejarPuntaje(puntajeJugador2);

        Exclusividad exclusividadTotal = exclusividadParcial1.validarExclusividad(exclusividadParcial2);

        exclusividadTotal.aplicarExclusividad(puntajeJugador);
        exclusividadTotal.aplicarExclusividad(puntajeJugador2);

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
