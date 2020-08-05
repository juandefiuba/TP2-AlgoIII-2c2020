package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.*;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.EstadoDeRespuesta;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeBien;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Puntos.*;

import java.util.Iterator;
import java.util.LinkedList;

public class PreguntaVerdaderoFalso {

    protected LinkedList<Opcion> opciones;

    public PreguntaVerdaderoFalso(LinkedList<Opcion> opcionesDeLaPregunta) {
        this.opciones = opcionesDeLaPregunta;
    }

    public Puntaje puntuarJugador(Jugador jugador) {
        Iterator iter = opciones.iterator();
        LinkedList<Opcion> respuestaDelJugador = new LinkedList<>();
        Puntaje puntajeDelJugador = new Puntaje();

        Opcion primeraOpcion = (Opcion) iter.next();
        primeraOpcion.obtenerPuntosDelJugador(jugador, respuestaDelJugador);
        Opcion segundaOpcion = (Opcion) iter.next();
        segundaOpcion.obtenerPuntosDelJugador(jugador, respuestaDelJugador);
        respuestaDelJugador.forEach(opcion -> puntajeDelJugador.sumarPuntos(this.calificarOpcion(opcion)));
        return puntajeDelJugador;
    }

    public Iterator obtenerOpciones() {
        return opciones.iterator();
    }

    public Punto calificarOpcion(Opcion opcion){
        return opcion.validarOpcion(this);
    }

    public Punto calificarOpcion(OpcionCorrecta opcion){
        return new PuntoPositivo();
    }

    public Punto calificarOpcion(OpcionIncorrecta opcion){
        return new PuntoNeutro();
    }

}
