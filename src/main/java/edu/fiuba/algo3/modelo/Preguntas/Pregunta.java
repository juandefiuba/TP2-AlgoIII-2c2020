package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.PuntajeNeutro;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class Pregunta { //esta clase podría ser abstracta, pero actualmente ningún método suyo lo es

    protected LinkedList<Opcion> opciones;

    protected Pregunta(LinkedList<Opcion> opcionesDeLaPregunta) {
        this.opciones = opcionesDeLaPregunta;
    }

    public Puntaje puntuarJugador(Jugador jugador) {
        LinkedList<Opcion> respuestaDelJugador = new LinkedList<>();
        Puntaje puntajeDelJugador = new Puntaje();

        opciones.forEach(opcion -> opcion.obtenerLRespuestaDelJugador(jugador, respuestaDelJugador));
        Iterator iter = respuestaDelJugador.iterator();

        while (iter.hasNext()){
            Opcion opcionAuxiliar = (Opcion)iter.next();
            puntajeDelJugador = this.calificarOpcion(opcionAuxiliar, puntajeDelJugador);
        }
        return puntajeDelJugador;
    }

    public Iterator obtenerOpciones() {
        return opciones.iterator();
    }

    public abstract Puntaje calificarOpcion(Opcion opcion, Puntaje puntajeDelJugador);
    public abstract Puntaje calificarOpcion(OpcionCorrecta opcion, Puntaje puntajeDeRespuesta);
    public Puntaje calificarOpcion(OpcionIncorrecta opcion, Puntaje puntajeDeRespuesta){
        puntajeDeRespuesta = new PuntajeNeutro();
        return puntajeDeRespuesta;
    }
}
