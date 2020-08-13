package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Jugador;
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

    public void puntuarJugadores(Jugador jugador, Jugador jugador2){

        Puntaje puntajeJugador = super.puntuarJugador(jugador);
        Puntaje puntajeJugador2 = super.puntuarJugador(jugador2);

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


}
