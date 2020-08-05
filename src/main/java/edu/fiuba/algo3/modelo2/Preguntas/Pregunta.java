package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeBien;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Jugador;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;
import edu.fiuba.algo3.modelo2.Puntos.PuntoNeutro;
import edu.fiuba.algo3.modelo2.Puntos.PuntoPositivo;

import java.util.Iterator;
import java.util.LinkedList;

public class Pregunta { //esta clase podría ser abstracta, pero actualmente ningún método suyo lo es

    protected ColeccionDeOpciones opciones;
    protected LinkedList<Jugador> jugadores;

    protected Pregunta(ColeccionDeOpciones opciones) {
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

    //por default una pregunta devuelve 1 punto siempre que se responda la pregunta bien, salvo exepciones
    public Puntaje calificarRespuesta(RespondeBien unEstadoRespuesta) {
        Puntaje puntajeADevolver = new Puntaje();
        puntajeADevolver.sumarPuntos(new PuntoPositivo());
        return puntajeADevolver;
    }

    // devuelvo puntaje neutro por default, toda pregunta clasica devuelve este puntaje
    public Puntaje calificarRespuesta(RespondeMal unEstadoRespuesta) {
        Puntaje puntajeADevolver = new Puntaje();
        puntajeADevolver.sumarPuntos(new PuntoNeutro());
        return puntajeADevolver;
    }

}
