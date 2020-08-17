package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeNulo;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public abstract class PreguntaBase implements Pregunta{

    protected LinkedList<Opcion> opciones;
    protected Map<Jugador, LinkedList<Opcion>> respuestasDeLosJugadores;

    public Puntaje puntajeDelJugador;

    protected PreguntaBase(LinkedList<Opcion> opcionesDeLaPregunta) {
        this.puntajeDelJugador = new PuntajeNulo();
        this.opciones = opcionesDeLaPregunta;
        this.respuestasDeLosJugadores = new HashMap<>();
    }

    @Override
    public void agregarRespuestaDeJugador(Jugador jugador, LinkedList<Opcion> respuestas){
        this.respuestasDeLosJugadores.put(jugador, respuestas);
    }

    @Override
    public Iterator obtenerOpciones() {
        return opciones.iterator();
    }

    @Override
    public void calificarRespuesta(Opcion opcion){
        opcion.validarOpcion(this);
    }

    protected Puntaje obtenerPuntajeBaseDelJugador(Jugador unJugador) {

        this.puntajeDelJugador = new PuntajeValido();
        LinkedList<Opcion> respuestaDelJugador = this.respuestasDeLosJugadores.get(unJugador);

        respuestaDelJugador.forEach(opcion -> this.calificarRespuesta(opcion));
        return this.puntajeDelJugador;
    }
}
