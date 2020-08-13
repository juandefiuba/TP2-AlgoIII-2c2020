package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.RespondeBien;
import edu.fiuba.algo3.modelo.Opcion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.PuntajeNeutro;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public abstract class Pregunta {

    protected LinkedList<Opcion> opciones;
    protected Map<Jugador, LinkedList<Opcion>> respuestasDeLosJugadores;
    protected Map<Jugador, Puntaje> puntajesDeLosJugadores;
    public Puntaje puntajeDelJugador;

    protected Pregunta(LinkedList<Opcion> opcionesDeLaPregunta) {
        this.puntajeDelJugador = new PuntajeNeutro();
        this.opciones = opcionesDeLaPregunta;
        this.respuestasDeLosJugadores = new HashMap<>();
        this.puntajesDeLosJugadores = new HashMap<>();
    }

    public Puntaje puntuarJugador(Jugador jugador) {
        if (this.puntajesDeLosJugadores.containsKey(jugador)){
            return this.puntajesDeLosJugadores.get(jugador);
        }
        this.puntajeDelJugador = new PuntajeValido();
        LinkedList<Opcion> respuestaDelJugador = this.respuestasDeLosJugadores.get(jugador);

        respuestaDelJugador.forEach(opcion -> this.calificarRespuesta(opcion));
        this.puntajesDeLosJugadores.put(jugador, this.puntajeDelJugador);
        return this.puntajeDelJugador;
    }

    public Iterator obtenerOpciones() {
        return opciones.iterator();
    }
    public void calificarRespuesta(Opcion opcion){
        opcion.validarOpcion(this);
    }
    public abstract void calificarRespuesta(RespondeBien calificador);
    public abstract void calificarRespuesta(RespondeMal calificador);

    public void agregarRespuestaDeJugador(Jugador jugador, LinkedList<Opcion> respuestas){
        this.respuestasDeLosJugadores.put(jugador, respuestas);
    }
}
