package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeBien;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Jugador;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class Pregunta {

    protected ColeccionDeOpciones opciones;
    protected LinkedList<Jugador> jugadores;

    public Pregunta(ColeccionDeOpciones opciones) {
        this.opciones = opciones;
        this.jugadores = new LinkedList<>();
    }

    public Iterator obtenerOpciones() {
        return this.opciones.obtenerIterador();
    }

    public void puntuarJugadores() {
        opciones.asignaEstadosDeRespuestasDeJugadores();
        jugadores.forEach(jugador -> jugador.sumarPuntos(this));
    }

    public void registrarNuevoJugador(Jugador jugador) {
        jugadores.add(jugador);
        opciones.inscribirJugador(jugador);
    }

    public abstract int calificarRespuesta(RespondeBien unEstadoRespuesta);
    public abstract int calificarRespuesta(RespondeMal unEstadoRespuesta);
}
