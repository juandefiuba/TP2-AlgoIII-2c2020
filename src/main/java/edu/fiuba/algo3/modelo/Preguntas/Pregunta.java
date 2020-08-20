package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeMal;

import java.util.Iterator;
import java.util.LinkedList;


public interface Pregunta {

    Iterator obtenerOpciones();
    void puntuarJugadores(Jugador jugador, Jugador jugador2);
    void calificarRespuesta(Opcion opcion);
    void calificarRespuesta(RespondeBien calificador);
    void calificarRespuesta(RespondeMal calificador);
    void agregarRespuestaDeJugador(Jugador jugador, LinkedList<Opcion> respuestas);
    void agregarRespuestaDeJugador(Jugador jugador, Opcion opcion);
}
