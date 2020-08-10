package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.PuntajeNeutro;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public abstract class Pregunta { //esta clase podría ser abstracta, pero actualmente ningún método suyo lo es

    protected LinkedList<Opcion> opciones;
    protected Map<Jugador, LinkedList<Opcion>> respuestasDeLosJugadores;
    public Puntaje puntajeDelJugador;

    protected Pregunta(LinkedList<Opcion> opcionesDeLaPregunta) {
        this.puntajeDelJugador = new PuntajeNeutro();
        this.opciones = opcionesDeLaPregunta;
        this.respuestasDeLosJugadores = new HashMap<>();
    }

    public Puntaje puntuarJugador(Jugador jugador) {
        this.puntajeDelJugador = new Puntaje();
        LinkedList<Opcion> respuestaDelJugador = this.respuestasDeLosJugadores.get(jugador);

        respuestaDelJugador.forEach(opcion -> this.calificarOpcion(opcion));
        return this.puntajeDelJugador;
    }

    public Iterator obtenerOpciones() {
        return opciones.iterator();
    }
    public void calificarOpcion(Opcion opcion){
        opcion.validarOpcion(this);
    }
    public abstract void calificarOpcion(OpcionCorrecta opcion);
    public abstract void calificarOpcion(OpcionIncorrecta opcion);

    public void agregarRespuestaDeJugador(Jugador jugador, LinkedList<Opcion> respuestas){
        this.respuestasDeLosJugadores.put(jugador, respuestas);
    }
}
