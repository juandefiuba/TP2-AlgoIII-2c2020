package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import java.util.Iterator;
import java.util.LinkedList;


public interface Pregunta {

    Iterator obtenerOpciones();
    void puntuarJugadores(Jugador jugador, Jugador jugador2);
    void calificarRespuesta(Opcion opcion);
    void calificarRespuesta(RespondeBien calificador);
    void calificarRespuesta(RespondeMal calificador);
    void agregarRespuestaDeJugador(Jugador jugador, LinkedList<Opcion> respuestas);
}
