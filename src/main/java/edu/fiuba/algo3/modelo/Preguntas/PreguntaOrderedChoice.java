package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Exclusividades.Parcial.ExclusividadParcial;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeNulo;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class PreguntaOrderedChoice extends PreguntaBase{

    public PreguntaOrderedChoice(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
    }

    @Override
    public Puntaje obtenerPuntajeBaseDelJugador(Jugador jugador) {
        this.puntajeDelJugador = new PuntajeValido();
        LinkedList<Opcion> respuestaDelJugador = this.respuestasDeLosJugadores.get(jugador);
        Iterator iterOpciones = this.opciones.iterator();
        Iterator iterRespuesta = respuestaDelJugador.iterator();
        try {
            while (iterOpciones.hasNext()) {
                if (iterOpciones.next() != iterRespuesta.next()) {
                    this.calificarRespuesta(new RespondeMal());
                }
            }
        }catch (NoSuchElementException nse){
            this.calificarRespuesta(new RespondeMal());
        }
        this.calificarRespuesta(new RespondeBien());
        return this.puntajeDelJugador;
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
    public void calificarRespuesta(RespondeMal calificador) {
    this.puntajeDelJugador = new PuntajeNulo();
    }

    @Override
    public PreguntaOrderedChoice comoInstancia(){
        return this;
    }

}
