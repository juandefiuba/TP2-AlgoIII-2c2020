package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.PuntajeNeutro;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class PreguntaOrderedChoice extends Pregunta{

    public PreguntaOrderedChoice(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
    }

    @Override
    public Puntaje puntuarJugador(Jugador jugador) {
        this.puntajeDelJugador = new Puntaje();
        LinkedList<Opcion> respuestaDelJugador = this.respuestasDeLosJugadores.get(jugador);
        Iterator iterOpciones = this.opciones.iterator();
        Iterator iterRespuesta = respuestaDelJugador.iterator();
        try {
            while (iterOpciones.hasNext()) {
                if (iterOpciones.next() != iterRespuesta.next()) {
                    this.calificarOpcion(new OpcionIncorrecta());
                }
            }
        }catch (NoSuchElementException nse){
            this.calificarOpcion(new OpcionIncorrecta());
        }
        this.calificarOpcion(new OpcionCorrecta());
        return this.puntajeDelJugador;
    }

    @Override
    public void calificarOpcion(OpcionCorrecta opcion) {
        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }

    @Override
    public void calificarOpcion(OpcionIncorrecta opcion) {
        this.puntajeDelJugador = new PuntajeNeutro();
    }
}
