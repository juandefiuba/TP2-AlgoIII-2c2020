package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.PuntajeNeutro;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class Pregunta { //esta clase podría ser abstracta, pero actualmente ningún método suyo lo es

    protected LinkedList<Opcion> opciones;
    public Puntaje puntajeDelJugador;

    protected Pregunta(LinkedList<Opcion> opcionesDeLaPregunta) {
        this.puntajeDelJugador = new PuntajeNeutro();
        this.opciones = opcionesDeLaPregunta;
    }


    public Puntaje puntuarJugador(Jugador jugador) {
        LinkedList<Opcion> respuestaDelJugador = new LinkedList<>();
        this.puntajeDelJugador = new Puntaje();

        this.armarListaDeRespuestaDelJugador(jugador,respuestaDelJugador);
        respuestaDelJugador.forEach(opcion -> this.calificarOpcion(opcion));

        return puntajeDelJugador;
    }

    protected void armarListaDeRespuestaDelJugador(Jugador jugador, LinkedList<Opcion> respuesta){
        opciones.forEach(opcion -> opcion.obtenerLRespuestaDelJugador(jugador, respuesta) );
    }

    public Iterator obtenerOpciones() {
        return opciones.iterator();
    }
    public void calificarOpcion(Opcion opcion){
        opcion.validarOpcion(this);
    }
    public abstract void calificarOpcion(OpcionCorrecta opcion);
    public abstract void calificarOpcion(OpcionIncorrecta opcion);
}
